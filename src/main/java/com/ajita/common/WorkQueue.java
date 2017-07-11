package com.ajita.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkQueue<E> {
	// 线程安全的Queue, 阻塞队列BlockingQueue: put与get所在的方法不使用synchronized
	private BlockingQueue<E> list = new LinkedBlockingQueue<E>();
	private int size = 0;
	private static final int max_size = 10000;

	public boolean put(E e) {
		if(++size > max_size)
			return false;
		return list.add(e);
	}

	// take方法在队列空的时候会阻塞，直到有队列成员被放进来。
	public E get() throws InterruptedException {
		size--;
		return list.take();
	}

	public synchronized boolean empty() {
		return size <= 0 ? true: false;
	}

	public synchronized int size() {
		return size;
	}

	public synchronized void clear() {
		list.clear();
		size = 0;
	}

}
