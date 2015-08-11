package com.tingyun.databean;

public interface DataBeanLock {
	public boolean isLocked();
	public void	 lock();
	public void 	 unLock();
}
