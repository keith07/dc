package com.tingyun.event.bean;

import java.util.List;

public class DefaultEventSetting {

	/**
	 * 邮件目标列表
	 */
	private List<NotificationTarget> emailTargets;
	/**
	 * 短信目标列表
	 */
	private List<NotificationTarget> smsTargets;
	/**
	 * 是否启用通知
	 */
	private boolean enableNotification;
	
	/**
	 * 是否启用警报通知
	 * 如果没有接收方也应该认为没有启用
	 * @return
	 */
	public boolean isEnableNotification() {
		return enableNotification;
	}
	/**
	 * 获取邮件接收目标
	 * @return
	 */
	public List<NotificationTarget> getEmailTargets() {
		return emailTargets;
	}
	/**
	 * 获取短信接收目标
	 * @return
	 */
	public List<NotificationTarget> getSmsTargets() {
		return smsTargets;
	}
}
