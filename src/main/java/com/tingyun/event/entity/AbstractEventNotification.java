package com.tingyun.event.entity;

import java.util.Date;

public abstract class AbstractEventNotification {

	/**
	 * 账号ID
	 * @return
	 */
	public abstract int getAccountId();
	/**
	 * 关联应用 ID
	 * @return
	 */
	public abstract int getAppId();
	/**
	 * 事件通知类型
	 * @return
	 */
	public abstract int getNotificationType();
	/**
	 * 修改时间
	 * @return
	 */
	public abstract Date getMtime();
}
