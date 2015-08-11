package com.tingyun.event.service;

import java.util.Locale;

import com.tingyun.event.NotificationException;

/**
 * 用于处理警报通知
 * @author qi guan yi
 *
 */
public interface NotificationService {

	/**
	 * 发送警报通知
	 * @param to
	 * @param subject
	 * @param message
	 * @param locale
	 * @throws NotificationException
	 */
	public void sendNotification(String[] to, String subject, String message, Locale locale) throws NotificationException;
}
