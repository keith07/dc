package com.tingyun.event.trigger;

import java.util.List;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.bean.AlarmEventHolder;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.bean.DefaultEventSetting;
import com.tingyun.event.entity.KeyActionEvent;

public class KeyActionAlarmTrigger extends AbstractAlarmTrigger<DefaultAlarmEventTarget,AlarmData,KeyActionEvent,DefaultEventSetting> {

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
	protected List<KeyActionEvent> getOpenedAlarmEvents(
			DefaultAlarmEventTarget target, int eventType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected KeyActionEvent saveEvent(KeyActionEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DefaultAlarmEventTarget parseTarget(AlarmDataKey<AlarmData> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean needTriggerAlarm(AlarmEventHolder<KeyActionEvent> holder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean needTriggerNotification(
			AlarmEventHolder<KeyActionEvent> holder) {
		// TODO Auto-generated method stub
		return false;
	}

}
