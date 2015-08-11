package com.tingyun.event.service.impl;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;
import com.tingyun.event.service.AlarmLevelService;
import com.tingyun.event.service.CachedAlarmEventSettingService;

/**
 * @author qi guan yi
 *
 */
public class SysAlarmServiceImpl implements AlarmLevelService<AlarmDataKey<AlarmData>> {
	
	private CachedAlarmEventSettingService<?, ?> settingService;

	public int getAlarmLevel(AlarmDataKey<AlarmData> key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CachedAlarmEventSettingService<?, ?> getSettingService() {
		return settingService;
	}

	public void setSettingService(
			CachedAlarmEventSettingService<?, ?> settingService) {
		this.settingService = settingService;
	}

}
