package com.ajita.http;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.http.api.HttpRequest;

import com.ajita.common.Util;
import com.ajita.common.WorkQueue;
import com.ajita.model.GwRequestInfo;


class HttpServerHandle extends IoHandlerAdapter {

	private WorkQueue<Object> m_queueIn;
	
	 
	public HttpServerHandle(WorkQueue<Object> queueIn) {
		this.m_queueIn = queueIn;
	}

	/**
	 * MINA的异常回调方法。
	 * <p>
	 * 本类中将在异常发生时，立即close当前会话。
	 *
	 * @param session
	 *            发生异常的会话
	 * @param cause
	 *            异常内容
	 * @see IoSession#close(boolean)
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	/**
	 * MINA框架中收到客户端消息的回调方法。
	 * <p>
	 * 本类将在此方法中实现完整的即时通讯数据交互和处理策略。
	 * <p>
	 * 为了提升并发性能，本方法将运行在独立于MINA的IoProcessor之外的线程池中， 详见
	 * {@link ServerLauncher#initAcceptor()}中的MINA设置代码 。
	 *
	 * @param session
	 *            收到消息对应的会话引用
	 * @param message
	 *            收到的MINA的原始消息封装对象，本类中是 {@link IoBuffer}对象
	 * @throws Exception
	 *             当有错误发生时将抛出异常
	 */
	@Override
	public void messageReceived(IoSession session, Object message) {

		if (message instanceof HttpRequest) {
			// 请求，解码器将请求转换成HttpRequest对象
			HttpRequest request = (HttpRequest) message;
			// request.getParameter(arg0)
			String path = request.getRequestPath();
			if (path != null && path.equals("/favicon.ico"))
				return;
	
			GwRequestInfo info = new GwRequestInfo();
			info.setTimestramp(Util.currentTimestamp());
			info.setHttpRequest(request);
			info.setSession(session);
			
			// 若队列已满
			if (!m_queueIn.put(info)) {
				System.out.println("--- Put request to queueIn fail! size of  queueIn: ---" + m_queueIn.size());
				// 通知Client端队列已满,无法响应请求
				return;
			}
			System.out.println("--- Put request to (queueIn)! size of  queueIn: ---" + m_queueIn.size());
		}
	}

}