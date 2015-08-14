package com.tingyun.event.bean;

import com.tingyun.event.IAlarmEventTarget;

/**
 * 事件目标的数据库标示
 * 一个事件目标下会有很多事件，所以此处不能用event
 * @author qi guan yi
 *
 */
public class DefaultAlarmEventTarget implements IAlarmEventTarget {

	/**
	 * 事件目标类型
	 */
	private int type;
	/**
	 * 事件目标Id值
	 * 1:应用；2：关键应用；3：硬盘；4：服务器
	 */
	private int value;
	
	public static DefaultAlarmEventTarget newInstance(){
		return new DefaultAlarmEventTarget();
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
