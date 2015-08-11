package com.tingyun.event.service.impl;

import com.tingyun.event.EventConstants;
import com.tingyun.event.bean.DefaultAlarmEventTarget;
import com.tingyun.event.entity.ApplicationEventSetting;
import com.tingyun.event.service.CachedAlarmEventSettingService;

public class ApplicationAlarmEventSettingService  extends CachedAlarmEventSettingService<DefaultAlarmEventTarget,ApplicationEventSetting> {

	@Override
	protected ApplicationEventSetting loadSetting(DefaultAlarmEventTarget target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getEventTargetType() {
		return EventConstants.EVENT_TARGET_TYPE_APPLICATION;
	}

}
