package com.tingyun.event.bean;

import java.util.List;

import com.tingyun.event.IAlarmEventTarget;



/**
 * 警报数据标识
 * 用于定位接收的警报数据
 * @author qi guan yi
 *
 * @param <D>
 */
public class AlarmDataKey<D extends AlarmData> implements IAlarmEventTarget {

	/**
	 * 警报数据
	 * 一个警报对象会有多条警报数据
	 */
	private List<D> datas;
	/**
	 * 时间戳
	 */
	private int timestamp;
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setType(int type) {
		// TODO Auto-generated method stub
		
	}
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setValue(int value) {
		// TODO Auto-generated method stub
		
	}
	
	public List<D> getAllDatas(){
		return datas;
	}
}
