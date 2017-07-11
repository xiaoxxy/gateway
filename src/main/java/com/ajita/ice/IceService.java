package com.ajita.ice;

import com.ajita.common.Log;

public class IceService extends Thread {
	private boolean m_bExit;
	
	public IceService(){}
	
	@Override
	public void run() {
		
	}
	
	public void cancel() {
		this.m_bExit = true;
		Log.info("IceService thread exit: "+m_bExit);
	}

}
