package com.tingyun.event.entity;


public abstract class AbstractEventContact {
	/**
	 * 关联应用 ID
	 * @return
	 */
	public abstract int getAppId();
	/**
	 * 额外通知的邮件地址
	 * @return
	 */
	public abstract String getEmail();
	/**
	 * 额外通知的手机号码
	 * @return
	 */
	public abstract String getMobileNo();
}
