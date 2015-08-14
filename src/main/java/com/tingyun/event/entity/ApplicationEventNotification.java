package com.tingyun.event.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NL_U_APPLICATION_EVENT_NOTIFICATION")
public class ApplicationEventNotification extends AbstractEventNotification {

	/**
	 * 账号ID
	 */
	@Column(name="account_id", nullable=false)
	private int accountId;
	/**
	 * 关联应用 ID
	 */
	@Column(name="application_id", nullable=false)
	private int applicationId;
	/**
	 * 事件通知类型
	 */
	@Column(name="notification_type", nullable=false)
	private int notificationType;
	/**
	 * 修改时间
	 */
	@Column(name="mtime", nullable=false)
	private Date mtime;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	@Override
	public int getAppId() {
		return applicationId;
	}
}
