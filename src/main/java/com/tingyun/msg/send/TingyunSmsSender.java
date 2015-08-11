package com.tingyun.msg.send;

import java.util.Locale;
import java.util.concurrent.Future;

import com.networkbench.sms.Response;
import com.networkbench.sms.SmsCallback;
import com.networkbench.sms.SmsServiceProvider;

public class TingyunSmsSender implements SmsServiceProvider{

	public Future<Response> send(String mobileNo, String message, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	public Future<Response> send(String[] mobileNo, String message,
			Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendAsync(String mobileNo, String message, Locale locale) {
		// TODO Auto-generated method stub
		
	}

	public void sendAsync(String[] mobileNo, String message, Locale locale) {
		// TODO Auto-generated method stub
		
	}

	public void sendAsync(String mobileNo, String message, Locale locale,
			SmsCallback callback) {
		// TODO Auto-generated method stub
		
	}

	public void sendAsync(String[] mobileNo, String message, Locale locale,
			SmsCallback callback) {
		// TODO Auto-generated method stub
		
	}

}
