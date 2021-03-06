package com.tingyun.event.service;

import java.util.HashMap;
import java.util.Map;

import com.tingyun.event.IAlarmEventTarget;
import com.tingyun.event.bean.DefaultEventSetting;


/**
 * 用于缓存报警设置
 * @author qi guan yi
 *
 * @param <S>
 */
public abstract class CachedAlarmEventSettingService<T extends IAlarmEventTarget,S extends DefaultEventSetting>{


	/**
	 * 缓存报警配置信息
	 */
	private Map<T,S> settings = new HashMap<T,S>();
	
	/**
	 * 从缓存中获取配置信息
	 * @param targetId
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	public S getSetting(int targetId){
//		int type = this.getEventTargetType();
//		T target = (T) T.newInstance();
//		target.setType(type);
//		target.setValue(targetId);
//		return getSetting(target);
//	}
	
	/**
	 * 从缓存中获取配置信息
	 * @param target
	 * @return
	 */
	public S getSetting(T target){
		S setting = settings.get(target);
		if(setting == null){
			setting = loadSetting(target);
			settings.put(target, setting);
		}
		return setting;
	}
	
	/**
	 * 重新加载警报设置
	 * @param target
	 * @return
	 */
	public S refreshSetting(T target){
		S setting = loadSetting(target);
		settings.put(target, setting);
		return setting;
	}

	/**
	 * 从数据库中获取配置信息
	 * @param targetId
	 * @return
	 */
	protected abstract S loadSetting(T target);
	/**
	 * 获取事件目标对象类型
	 * 1：应用；2：关键应用；3：硬盘；4：服务器
	 * @return
	 */
	protected abstract int getEventTargetType();
}
