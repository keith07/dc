package com.tingyun.event.bean;

import java.util.Date;

/**
 * 警报事件实体的基类
 * @author qi guan yi
 *
 */
public abstract class AbstractEventEntity implements Comparable<AbstractEventEntity> {

	//TODO 找到需要的公用方法

	/** 
	 * 
	 */
	public int compareTo(AbstractEventEntity o) {

		if (o == null || this.getBeginTime().before(o.getBeginTime()) || this.getEventType() < o.getEventType() || this.getEventLevel() > o.getEventLevel())
			return -1;

		if (this.getBeginTime().after(o.getBeginTime()) || this.getEventType() > o.getEventType() || this.getEventLevel() < o.getEventLevel())
			return 1;

		return 0;
	}
	
	/**
	 * 开始时间
	 * @return
	 */
	public abstract Date getBeginTime();
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
}
