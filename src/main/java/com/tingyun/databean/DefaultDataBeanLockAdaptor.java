package com.tingyun.databean;

public class DefaultDataBeanLockAdaptor implements DataBeanLock {
	
	private boolean locked = false;
	
	public boolean isLocked() {
		return this.locked;
	}

	public void lock() {
		this.locked = true;
	}

	public void unLock() {
		throw new DataBeanLockException();
	}
	
	protected void checkLock(){
		if(this.locked){
			throw new DataBeanLockException();
		}
	}

	
}
