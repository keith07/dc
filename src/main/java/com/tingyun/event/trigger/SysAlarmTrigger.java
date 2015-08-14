package com.tingyun.event.trigger;

import java.util.List;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.bean.AlarmEventHolder;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.bean.DefaultEventSetting;
import com.tingyun.event.entity.ServerEvent;

public class SysAlarmTrigger extends AbstractAlarmTrigger<DefaultAlarmEventTarget,AlarmData,ServerEvent,DefaultEventSetting> {

	@Override
	protected AlarmDataKey<AlarmData> parseAlarmData(String jsonDdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getAlarmLevel(AlarmDataKey<AlarmData> dataKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected List<ServerEvent> getOpenedAlarmEvents(
			DefaultAlarmEventTarget target, int eventType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ServerEvent saveEvent(ServerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DefaultAlarmEventTarget parseTarget(AlarmDataKey<AlarmData> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean needTriggerAlarm(AlarmEventHolder<ServerEvent> holder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean needTriggerNotification(
			AlarmEventHolder<ServerEvent> holder) {
		// TODO Auto-generated method stub
		return false;
	}

}
