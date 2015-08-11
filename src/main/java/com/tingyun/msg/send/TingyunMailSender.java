package com.tingyun.msg.send;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TingyunMailSender extends JavaMailSenderImpl {

	public void send(MimeMessage mimeMessage) throws MailException {
		//TODO before send
		super.send(mimeMessage);
		//TODO after send
	}
}
