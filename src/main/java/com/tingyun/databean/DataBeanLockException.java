package com.tingyun.databean;

public class DataBeanLockException extends RuntimeException {
	public DataBeanLockException() {
		super("DataBeanLockException");
	}
	
	public DataBeanLockException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 4294313639933308192L;
	
}
