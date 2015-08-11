package com.tingyun.event.service;

import com.tingyun.event.bean.AlarmData;
import com.tingyun.event.bean.AlarmDataKey;



/**
 * 用于检查事件的警报级别
 * @author qi guan yi
 *
 */
public interface AlarmLevelService<K extends AlarmDataKey<AlarmData>> {

	/**
	 * 获得警报级别
	 * @return
	 */
	public int getAlarmLevel(K key);
}
