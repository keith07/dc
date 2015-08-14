package com.tingyun.event.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NL_U_APPLICATION_EVENT_CONTACTS")
public class ApplicationEventContact extends AbstractEventContact {

	/**
	 * 关联应用 ID
	 */
	@Column(name="application_id", nullable=false)
	private int applicationId;
	/**
	 * 额外通知的邮件地址
	 */
	@Column(name="email", nullable=true)
	private String email;
	/**
	 * 额外通知的手机号码
	 */
	@Column(name="mobile_no", nullable=true)
	private String mobileNo;
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public int getAppId() {
		return applicationId;
	}
}
