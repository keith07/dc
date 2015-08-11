package com.tingyun.event;


public interface IAlarmEventTarget {

	public int getType();
	public void setType(int type);
	public int getValue();
	public void setValue(int value);
}
