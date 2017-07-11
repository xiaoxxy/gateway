package com.ajita.handler;

import java.util.Iterator;
import java.util.Vector;

import com.ajita.common.Log;
import com.ajita.common.WorkQueue;


public class WorkThreadPool {

	private boolean m_bStart;
	private int m_iSize;
	private Vector<WorkThread> m_vecWorker;
	private Handler m_pHandler;
	private WorkQueue<Object> m_pWorkQueue;

	public WorkThreadPool(Handler handler, WorkQueue<Object> workQueue) {
		this.m_pHandler = handler;
		this.m_pWorkQueue = workQueue;
	}

	public synchronized void start(int iSize) {
		if (m_bStart)
			Log.info("worker pool has been started");
		
		m_bStart = true;
		m_iSize = iSize;

		for (int i=0; i<m_iSize; i++)
		{
			WorkThread worker = new WorkThread(m_pHandler, m_pWorkQueue);
			worker.start();
			m_vecWorker.add(worker);
		}
		//  LOGINFO("worker pool start,size:%d",iSize);

	}

	public synchronized void stop() {
		if (!m_bStart)
			return;
		
		m_bStart = false;
		
		Iterator<WorkThread> iter = m_vecWorker.iterator();
		// LOGINFO("worker pool stop ...");
		while(iter.hasNext()){
			iter.next().cancel();
		}
		m_vecWorker.clear();
		// LOGINFO("worker pool stop success!");
	}

}
