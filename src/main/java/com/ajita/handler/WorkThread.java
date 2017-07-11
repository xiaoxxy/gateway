package com.ajita.handler;

import com.ajita.common.WorkQueue;

public class WorkThread extends Thread {

	private Handler m_pHandler;
	private WorkQueue<Object> m_pWorkQueue;
	private boolean m_bExit;

	public WorkThread(Handler handler, WorkQueue<Object> workQueue) {
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

	public void cancel() {
		this.m_bExit = true;
	}

}
