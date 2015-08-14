package com.tingyun.event.bean;

import com.tingyun.event.entity.AbstractEventEntity;



/**
 * 该实体用于缓存对事件操作的中间数据等信息
 * 在开启警报时创建
 * 在关闭警报时该数据将被写入数据库中
 * @author qi guan yi
 *
 * @param <E>
 */
public class AlarmEventHolder<E extends AbstractEventEntity> implements Comparable<AlarmEventHolder<E>> {

	/**
	 * 事件标示
	 */
	private int id;
	/**
	 * 事件类型：0 - 无 6 - 错误率超过阈值 7 - Apdex超过阈值 9 - 触发报警 10 - 解除报警通知 100 - 备忘
	 */
	private int eventType;
	/**
	 * 事件级别：0 - 无 1 - 警告 2 - 严重
	 */
	private int eventLevel;
	/**
	 * 事件开始时间
	 */
	private int beginTime;
	/**
	 * 事件结束时间
	 */
	private int endTime;
	/**
	 * 时间单位数
	 */
	private int timeCount;
	/**
	 * 警报触发时间段内的平均值或错误率
	 */
	private double value;
	/**
	 * 警报触发时间段内的请求数
	 */
	private int count;
	/**
	 * 状态：0 - 关闭 1 - 开放
	 */
	private int status;
	/**
	 * 事件跟踪ID（同一组事件使用同一个跟踪ID）
	 */
	private int eventTraceId;
	/**
	 * 事件实体
	 */
	private E event;
	/**
	 * 关联事件实体
	 * 警报通知事件跟警报结束通知事件，需要关联到具体的警报事件
	 * 对应的就是这个事件流的第一条警报事件
	 */
	private E relatedEvent;
	
	public AlarmEventHolder(E event){
		this.event = event;
	}
	
	/**
	 * 根据警报数据生成警报事件
	 * @param key
	 */
	public AlarmEventHolder(AlarmDataKey key){
		//TODO 
	}

	/* (non-Javadoc)
	 * 排序标准：开始时间、事件类型、事件级别
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AlarmEventHolder<E> holder) {
		if (holder == null || this.getBeginTime() < holder.getBeginTime() || this.getEventType() < holder.getEventType() || this.getEventLevel() > holder.getEventLevel())
			return -1;
		if (this.getBeginTime() > holder.getBeginTime() || this.getEventType() > holder.getEventType() || this.getEventLevel() < holder.getEventLevel())
			return 1;
		return 0;
	}

	/**
	 * 修正加权平均值
	 * @param value
	 * @param count
	 */
	public void weightedAverage(double value, int count) {
		this.value = (this.value * this.count + value * count)
				/ (this.count + count);
		this.count += count;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取事件持续时间戳
	 * 单位为分钟
	 * @return
	 */
	public int getTimePeriod(){
		//目前一分钟一份数据，因此直接返回timeCount
		return getTimeCount();
	}
	

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public int getEventLevel() {
		return eventLevel;
	}

	public void setEventLevel(int eventLevel) {
		this.eventLevel = eventLevel;
	}

	public int getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getEventTraceId() {
		return eventTraceId;
	}

	public void setEventTraceId(int eventTraceId) {
		this.eventTraceId = eventTraceId;
	}

	public E getEvent() {
		return event;
	}

	public void setEvent(E event) {
		this.event = event;
	}

	public E getRelatedEvent() {
		return relatedEvent;
	}

	public void setRelatedEvent(E relatedEvent) {
		this.relatedEvent = relatedEvent;
	}
}
