package com.ajita.handler;

import com.ajita.common.WorkQueue;

public class WorkThread2 implements Runnable{
	
	private Handler m_pHandler;
	private WorkQueue<Object> m_pWorkQueue;
	private boolean m_bExit;
	

	public WorkThread2(Handler handler, WorkQueue<Object> workQueue){
		this.m_bExit = false;
		this.m_pHandler = handler;
		this.m_pWorkQueue = workQueue;
	}

	@Override
	public void run() {	
		Object pkt;
		while (!m_bExit) {
			try {
				pkt = m_pWorkQueue.get();
				System.out.println("--- Get data from (queueIn)!  then handle packet ---");
				// handle packet	
				m_pHandler.OnPacket(pkt);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				// LOGERROR("exception: Unknown exception");
			}		
		}
		
	}
	
	public void cancel(){
		m_bExit = true;
	}

}
