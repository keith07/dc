package com.tingyun.event.bean;

/**
 * 通知目标
 * @author qi guan yi
 *
 */
public class NotificationTarget {

	/**
	 * 邮件地址
	 */
	private String emailAddr;
	/**
	 * 手机号码
	 */
	private int phoneNum;
	/**
	 * 通知类型
	 * 1:邮件通知；2：短信通知
	 */
	private int type;
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
