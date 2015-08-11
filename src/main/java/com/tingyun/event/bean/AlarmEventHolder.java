package com.tingyun.event.bean;



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
	 * 警报触发时间段内的平均值或错误率
	 */
	private float value;
	/**
	 * 警报触发时间段内的请求数
	 */
	private int count;
	/**
	 * 状态：0 - 关闭 1 - 开放
	 */
	private int status;
	/**
	 * 事件实体
	 */
	private E event;
	
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
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AlarmEventHolder<E> holder) {
		//TODO 逻辑未知
		if (holder == null || this.getBeginTime() < holder.getBeginTime() || this.getEventType() < holder.getEventType() || this.getEventLevel() > holder.getEventLevel())
			return -1;
		if (this.getBeginTime() > holder.getBeginTime() || this.getEventType() > holder.getEventType() || this.getEventLevel() < holder.getEventLevel())
			return 1;
		return 0;
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
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

	public E getEvent() {
		return event;
	}

	public void setEvent(E event) {
		this.event = event;
	}
}
