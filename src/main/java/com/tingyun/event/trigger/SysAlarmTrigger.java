package com.tingyun.event.trigger;

import java.util.List;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.entity.ServerEvent;

public class SysAlarmTrigger extends AbstractAlarmTrigger<DefaultAlarmEventTarget,AlarmData,ServerEvent> {

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
	protected ServerEvent createEvent(AlarmDataKey<AlarmData> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DefaultAlarmEventTarget parseTarget(AlarmData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
