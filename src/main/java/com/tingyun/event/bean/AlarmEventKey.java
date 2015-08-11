package com.tingyun.event.bean;

import com.tingyun.event.IAlarmEventTarget;


/**
 * 警报事件标示
 * 包含警报级别与数据库标示
 * @author qi guan yi
 *
 * @param <T>
 */
public class AlarmEventKey<T extends IAlarmEventTarget> {

	public AlarmEventKey(T target, int alarmLevel) {
		// TODO Auto-generated constructor stub
		this.target = target;
		this.level = alarmLevel;
	}
	/**
	 * 目标对象
	 */
	private T target;
	/**
	 * 事件级别
	 */
	private int level;
	public T getTarget() {
		return target;
	}
	public void setTarget(T target) {
		this.target = target;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
