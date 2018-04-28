package com.ajita.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ajita.common.Log;
import com.ajita.common.WorkQueue;

public class WorkThreadPool3 {

	private boolean m_bStart;
	private int m_iSize;

	ExecutorService fixedThreadPool = null;

	private Handler m_pHandler;
	private WorkQueue<Object> m_pWorkQueue;

	public WorkThreadPool3(Handler handler, WorkQueue<Object> workQueue) {
		this.m_bStart = false;
		this.m_pHandler = handler;
		this.m_pWorkQueue = workQueue;
	}

	public void start(int iSize) {
		if (m_bStart)
			Log.info("worker pool has been started");

		m_bStart = true;
		m_iSize = iSize;
		
		// LOGINFO("worker pool start,size:%d",iSize);
		fixedThreadPool = Executors.newFixedThreadPool(iSize);
		for (int i = 0; i < m_iSize; i++) {
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					Object pkt;
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
			});
		}
	}

	public void stop() {
		if (!m_bStart)
			return;

		m_bStart = false;
		fixedThreadPool.shutdown();
		// LOGINFO("worker pool stop ...");

	}

}
