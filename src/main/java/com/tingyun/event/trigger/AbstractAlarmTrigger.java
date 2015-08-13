package com.tingyun.event.trigger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tingyun.event.EventConstants;
import com.tingyun.event.IAlarmEventTarget;
import com.tingyun.event.bean.AbstractEventEntity;
import com.tingyun.event.bean.AbstractEventSetting;
import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.bean.AlarmEventHolder;
import com.tingyun.event.bean.AlarmEventKey;
import com.tingyun.event.service.AbstractTemplateNotificationService;
import com.tingyun.event.service.CachedAlarmEventSettingService;
import com.tingyun.event.service.NotificationService;

/**
 * 触发警报的基类
 * @author qi guan yi
 *
 * @param <T>
 */
public abstract class AbstractAlarmTrigger<T extends IAlarmEventTarget,D extends AlarmData,E extends AbstractEventEntity,S extends AbstractEventSetting>{
	
	/**
	 * 所有收到的数据
	 * 每个key对应一条数据
	 */
	private List<AlarmDataKey<D>> alarmDataKeys = new ArrayList<AlarmDataKey<D>>();
	/**
	 * 同类型警报的历史数据
	 */
	private Map<AlarmEventKey<T>,List<AlarmEventHolder<E>>> alarmEvents = new HashMap<AlarmEventKey<T>,List<AlarmEventHolder<E>>>();
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 警报设置服务
	 */
	private CachedAlarmEventSettingService<T,S> eventSettingService;
	/**
	 * 邮件发送服务
	 */
	private AbstractTemplateNotificationService mailNotificationService;
	/**
	 * 短信发送服务
	 */
	private NotificationService smsNotificationService;
	
	/**
	 * 定时触发警报处理
	 */
	public void schedule(){
		//如果key的时间戳+预留数据统计延时时间大于现在时间 则移除该key
		int now = (int) (System.currentTimeMillis()/1000);
		for(AlarmDataKey<D> key : alarmDataKeys){
			if(key.getTimestamp() + EventConstants.ALARM_DATA_DELAY > now)
				alarmDataKeys.remove(key);
		}
		//取到每个数据对应的警报设置，然后判断该数据是否触发警报以及警报类型
		for(AlarmDataKey<D> key : alarmDataKeys){
			int level = getAlarmLevel(key);
			switch(level){
				//不触发警报
				case EventConstants.EVENT_LEVEL_NONE:
					tryCloseAlarmEvent(EventConstants.EVENT_LEVEL_WARN,key);
					tryCloseAlarmEvent(EventConstants.EVENT_LEVEL_CRITICAL,key);
				break;
				//触发警告事件警报
				case EventConstants.EVENT_LEVEL_WARN:
					tryTriggerAlarmEvent(EventConstants.EVENT_LEVEL_WARN,key);
					tryCloseAlarmEvent(EventConstants.EVENT_LEVEL_CRITICAL,key);
				break;
				/* 严重警报只能是从警告警报转换而来，所以只需要触发严重警报即可 */
				//触发严重事件警报
				case EventConstants.EVENT_LEVEL_CRITICAL:
					tryTriggerAlarmEvent(EventConstants.EVENT_LEVEL_CRITICAL,key);
			}
			//防止重复触发
			alarmDataKeys.remove(key);
		}
	}
	
	/**
	 * 接收数据处理
	 * 接收json数据并置入alarmDataKeys中
	 * @param jsonData
	 */
	public void receive(String jsonData){
		AlarmDataKey<D> key = parseAlarmData(jsonData);
		if(key != null)
			alarmDataKeys.add(key);
	}
	
	/**
	 * 将接收的json转成AlarmDataKey对象
	 * @param jsonDdata
	 * @return
	 */
	protected abstract AlarmDataKey<D> parseAlarmData(String jsonDdata);
	/**
	 * 根据警报设置判断该数据对应的警报级别
	 * @param dataKey
	 * @return
	 */
	protected abstract int getAlarmLevel(AlarmDataKey<D> dataKey);
	/**
	 * 取到数据库中开启状态的同类型警报
	 * @param target
	 * @param eventType
	 * @return
	 */
	protected abstract List<E> getOpenedAlarmEvents(T target, int eventType);
	/**
	 * 保存警报事件到数据库中
	 * @param event
	 * @return
	 */
	protected abstract E saveEvent(E event);
	/**
	 * 转成各自的target类型
	 * @param data
	 * @return
	 */
	protected abstract T parseTarget(AlarmDataKey<D> data);
	
	/**
	 * 判断是否需要触发警报
	 * @return
	 */
	protected abstract boolean needTriggerAlarm(AlarmEventHolder<E> holder);
	
	/**
	 * 判断是否需要触发通知
	 * @return
	 */
	protected abstract boolean needTriggerNotification(AlarmEventHolder<E> holder);

	/**
	 * 尝试触发警报，是否发最终触发警报将根据若干限制条件决定：
	 *	+-------------------------------------------------------------------------------+
	 *	|				|	警告事件		|	严重事件		|	报警通知						|
	 *	+-------------------------------------------------------------------------------+
	 *	|	性能警报		|	持续3分钟	|	持续3分钟	|	持续15分钟且吞吐量 >= 5rpm	|
	 *	+-------------------------------------------------------------------------------+
	 *	|	错误警报		|	持续3分钟	|	持续3分钟	|	持续 5分钟且吞吐量 >= 5rpm	|
	 *	+-------------------------------------------------------------------------------+
	 *	1.如果有开放的严重事件但起始时间不同，则正常触发警告事件
	 *		a.严重事件包含警报事件则只触发严重事件
	 *		b.否则各自独立触发
	 *	2.如果有开放的严重事件且起始时间相同，则优先触发严重事件，并将告警事件的时间段扣去严重事件的时间段
	 * @param alarmLevel
	 * @param alarmDataKey
	 */
	private void tryTriggerAlarmEvent(int alarmLevel,AlarmDataKey<D> alarmDataKey){
		//获取该警报对象的历史警报数据
		T target = parseTarget(alarmDataKey);
		AlarmEventKey<T> key = new AlarmEventKey<T>(target,alarmLevel);
		List<AlarmEventHolder<E>> events = new ArrayList<AlarmEventHolder<E>>();
		List<AlarmEventHolder<E>> existedEvents = alarmEvents.putIfAbsent(key,events);
		AlarmEventHolder<E> evt = new AlarmEventHolder<E>(alarmDataKey);
		//如果缓存中没有，则去数据库中获取
		if(existedEvents == null){
			List<E> eventsSinceLastRestart = getOpenedAlarmEvents(parseTarget(alarmDataKey),alarmLevel);
			if(eventsSinceLastRestart != null && eventsSinceLastRestart.size() > 0){
				for(E event : eventsSinceLastRestart){
					AlarmEventHolder<E> holder = new AlarmEventHolder<E>(event);
					//TODO 其他转换逻辑
					//如果重复则覆盖之前事件
					int index = Collections.binarySearch(events, holder);
					if(index < 0){
						events.add(-index -1,holder);
					}else{
						events.add(index,holder);
					}
				}
				//二者应指向同一对象
				existedEvents = events;
				//警报通知和警报结束通知需要关联对应事件
				for(AlarmEventHolder<E> _holder : events){
					if(_holder.getEventType() == EventConstants.EVENT_TYPE_NOTIFICATION || _holder.getEventType() == EventConstants.EVENT_TYPE_NOTIFICATION_CLOSED){
						//如果是排序好的，应该只需要遍历在该事件之前的事件即可
						for(AlarmEventHolder<E> _relHolder : events){
							if(_relHolder.getId() == _holder.getRelatedEvent().getRelatedEventId()){
								_holder.setRelatedEvent(_relHolder.getEvent());
								break;
							}
						}
					}
				}
			}else{
				events.add(evt);
			}
		}
		//进行排序，应该是排序好的吧？
		Collections.sort(existedEvents);
		//如果existedEvents不为空
		if(existedEvents != null){
			int index = Collections.binarySearch(existedEvents, evt);
			boolean triggerNewEvent = true;
			//1.进行二进制比较，如果报警内容匹配则忽略
			if(index >= 0){
				return;
			}else{
				for(AlarmEventHolder<E> existEvent : existedEvents){
					//2.否则查找同类型开启状态的警报
					//	找到警报后做两种处理
					if(existEvent.getEventType() == alarmDataKey.getType() && existEvent.getEventLevel() == alarmLevel && existEvent.getStatus() == EventConstants.EVENT_STATUS_OPEN){
						//		1.该警报开始时间小于当前警报时间，则将本警报合入该警报，重置结束时间为本警报时间+60的延时，修正加权平均值
						if(existEvent.getBeginTime() < evt.getBeginTime()){
							existEvent.setEndTime(evt.getEndTime()+ 60);
							existEvent.weightedAverage(evt.getValue(), evt.getCount());
							triggerNewEvent = false;
						}else{
							//		2.否则判断警报是否已触发（eventTraceId=0代表未触发）已触发则修正开始时间为当前警报时间，修正加权平均值；未触发则触发本警报
							if(existEvent.getEventTraceId() != 0){
								existEvent.setBeginTime(evt.getBeginTime());
								existEvent.weightedAverage(evt.getValue(), evt.getCount());
								triggerNewEvent = false;
							}else{
							}
							
						}
						break;
					}
				}
				//	在历史警报里插入本警报
				if(triggerNewEvent){
					
					existedEvents.add(-index - 1,evt);
				}
			}
		}
		//检查警报触发条件：设置为空则抛异常
		if(eventSettingService.getSetting(target) == null){
			logger.error("mobile event settings not found for mobileAppId:{}, targetId:{}", target.toString());
		}
		//开始对existedEvents中的事件触发警报
		boolean actualTriggerAlarm = false;
		boolean hasOpenedNotification = false;
		if(existedEvents != null){
			for(int i = 0; i < existedEvents.size(); i++){
				AlarmEventHolder<E> event = existedEvents.get(i);
				if(event.getEventType() == EventConstants.EVENT_TYPE_NOTIFICATION){
					if(event.getStatus() == EventConstants.EVENT_STATUS_OPEN)
						hasOpenedNotification = true;
				}else if(event.getEventType() == EventConstants.EVENT_TYPE_NOTIFICATION_CLOSED){
					//警报关闭通知事件不作处理
				}else{
					if(event.getEventLevel() == EventConstants.EVENT_LEVEL_WARN && needTriggerAlarm(event)){
//				 *	1.如果有开放的严重事件但起始时间不同，则正常触发警告事件
//				 *		a.严重事件包含警报事件则只触发严重事件
//				 *		b.否则各自独立触发
//				 *	2.如果有开放的严重事件且起始时间相同，则优先触发严重事件，并将告警事件的时间段扣去严重事件的时间段
						AlarmEventHolder<E> preEvent = null;
						for(int j = i - 1; j >= 0; j--){
							AlarmEventHolder<E> _preEvent = existedEvents.get(j);
							if(_preEvent != null && _preEvent.getStatus() != EventConstants.EVENT_STATUS_DELETE)
								preEvent = _preEvent;
						}
						if(preEvent == null){
							actualTriggerAlarm = true;
						}else{
							if(preEvent.getEventLevel() == EventConstants.EVENT_LEVEL_CRITICAL && preEvent.getEventType() == event.getEventType()){
								if(preEvent.getBeginTime() != event.getBeginTime()){
									if(preEvent.getBeginTime() < event.getBeginTime() && preEvent.getEndTime() > event.getEndTime()){
										event.setStatus(EventConstants.EVENT_STATUS_DELETE);
									}else{
										actualTriggerAlarm = true;
									}
								}else{
									if(preEvent.getStatus() == EventConstants.EVNET_STATUS_CLOSE){
										event.setBeginTime(preEvent.getEndTime());
										//此处timeCount不会出现负值
										event.setTimeCount(event.getTimeCount() - preEvent.getTimeCount());
										if(needTriggerAlarm(event)){
											actualTriggerAlarm = true;
										}else{
											event.setStatus(EventConstants.EVENT_STATUS_DELETE);
										}
									}
								}
								
							}else{
								// 有可能是通知或者解除通知事件
								// 根据该List的设计，开放的警告事件后必然是严重事件（如果有），进入这里说明异常了，需要排查
								logger.error("NEVER should reach here: a WARN-level event followed by an event with level: {}, expected: {}, event followed: {}", preEvent.getEventLevel(), EventConstants.EVENT_LEVEL_CRITICAL, preEvent);
								
								// 为保险起见，此处直接触发警告事件
								actualTriggerAlarm = true;
							}
						}
						
					}else if(event.getEventLevel() == EventConstants.EVENT_LEVEL_CRITICAL && needTriggerAlarm(event)){
						actualTriggerAlarm = true;
					}
					
					//实际触发警报
					if(actualTriggerAlarm)
						onTriggerEvent(event);
				}
			}
		}
		//
		//
		if(!hasOpenedNotification){
		//检查是否发送报警通知
			triggerEventNotification(parseTarget(alarmDataKey),evt,alarmDataKey.getTimestamp());
		}
	}
	
	/**
	 * 触发警报事件
	 * @param event
	 */
	private void onTriggerEvent(AlarmEventHolder<E> event){
		
	}
	
	/**
	 * @param alarmLevel
	 * @param alarmDataKey
	 */
	private void tryCloseAlarmEvent(int alarmLevel,AlarmDataKey<D> alarmDataKey){
		//基本逻辑类似trigger
		//如果同类同级别事件均已关闭，则清理事件列表
		
	}
	
	/**
	 * 实际发送警报
	 * @param target
	 * @param evt
	 * @param timestamp
	 */
	private void triggerEventNotification(T target,AlarmEventHolder<E> evt,int timestamp){
		//如果警报类型为不警报，则跳过
		//将警报写库，加入existedEvents中
		//发送报警邮件/短信：相同语言及时区的通知合并发送
		//logger.debug("sending mail notification on target #{}, subject: {}, eventName: {}, trimmedEventName: {}, mobileAppName: {}", target.toString(), subject, eventName, trimmedEventName, "#" + settings.getId() + "," + settings.getName());
		//this.mailNotificationService.sendNotification(recipients.toArray(new String[recipients.size()]), subject, notificationContext, locale);
		// 告警短信格式：「${app_name}」HTTP错误率${event_value}超阈值（序号：${event_id}）【听云】
		// 短信不允许超过70字
		//logger.debug("sending sms notification on target #{}, message: {}, eventName: {}, mobileAppName: {}", target.toString(), message, eventName, "#" + settings.getId() + "," + settings.getName());
		//this.smsNotificationService.sendNotification(recipients.toArray(new String[recipients.size()]), null, message, locale);
	}
	
	/**
	 * 发送警报解除
	 * @param target
	 * @param event
	 * @param timestamp
	 */
	private void triggerCloseEventNotification(T target,AlarmEventHolder<E> event,int timestamp){

	}
}
