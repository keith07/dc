package com.tingyun.event.trigger;

import java.util.List;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.entity.DiskEvent;

/**
 * 硬盘警报具体通知
 * @author qi guan yi
 *
 */
public class DiskAlarmTrigger extends AbstractAlarmTrigger<DefaultAlarmEventTarget,AlarmData,DiskEvent> {

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
	protected List<DiskEvent> getOpenedAlarmEvents(
			DefaultAlarmEventTarget target, int eventType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DiskEvent saveEvent(DiskEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DefaultAlarmEventTarget parseTarget(AlarmDataKey<AlarmData> data) {
		// TODO Auto-generated method stub
		return null;
	}


}
