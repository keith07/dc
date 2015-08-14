package com.tingyun.event.entity;

import java.util.Date;

/**
 * 警报事件实体的基类
 * @author qi guan yi
 *
 */
public abstract class AbstractEventEntity {

	//TODO 找到需要的公用方法
	
	/**
	 * 开始时间
	 * @return
	 */
	public abstract Date getBeginTime();
	
	/**
	 * 结束时间
	 * @return
	 */
	public abstract Date getEndTime();
	
	/**
	 * 结束时间
	 */
	public abstract void setEndTime(Date endTime);
	/**
	 * 事件类型
	 * @return
	 */
	public abstract int getEventType();
	/**
	 * 事件级别
	 * @return
	 */
	public abstract int getEventLevel();
	/**
	 * 事件状态
	 * @return
	 */
	public abstract int getStatus();
	/**
	 * 事件跟踪ID（同一组事件使用同一个跟踪ID）
	 * @return
	 */
	public abstract int getEventTraceId();
	/**
	 * 关联事件标示
	 * @return
	 */
	public abstract int getRelatedEventId();
}
