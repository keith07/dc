package com.tingyun.event.service.impl;

import com.tingyun.event.EventConstants;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.bean.DefaultEventSetting;
import com.tingyun.event.service.CachedAlarmEventSettingService;

public class SysAlarmEventSettingService  extends CachedAlarmEventSettingService<DefaultAlarmEventTarget,DefaultEventSetting> {

	@Override
	protected DefaultEventSetting loadSetting(DefaultAlarmEventTarget target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getEventTargetType() {
		return EventConstants.EVENT_TARGET_TYPE_SYS;
	}

}
