package com.tingyun.event.bean;

import java.util.Date;

import com.tingyun.event.IAlarmEventTarget;
import com.tingyun.event.entity.AbstractEventEntity;


/**
 * 由探针上传的数据
 * 并不一定是警报事件，但是跟警报事件结构应该差不多
 * @author qi guan yi
 *
 */
public class AlarmData extends AbstractEventEntity implements IAlarmEventTarget {

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

	@Override
	public Date getBeginTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEndTime(Date endTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEventType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEventLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEventTraceId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRelatedEventId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
