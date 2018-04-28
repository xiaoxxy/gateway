package com.ajita.http;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.http.HttpServerCodec;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.ajita.common.Log;
import com.ajita.common.WorkQueue;
import com.ajita.handler.Handler;
import com.ajita.handler.WorkThreadPool;


public class HttpServer {

	public static void main(String[] args) throws Exception {

		ServiceAgent serviceAgent = new ServiceAgent();
		ServiceAgent.Instance(serviceAgent);
		ServiceAgent.Instance().start();
		Log.info("initialize inner agent service success.");

		// initialize inner ice service	
		WorkQueue<Object> queueIn = new WorkQueue<Object>();
		WorkQueue<Object> queueOut = new WorkQueue<Object>();

		// Acceptor设置
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("codec", new HttpServerCodec());

		// 设置MINA2的IoHandler实现类
		acceptor.setHandler(new HttpServerHandle(queueIn));
		// 服务端开始侦听
		acceptor.bind(new InetSocketAddress(8888));

		Handler handler = new Handler(queueOut);
		WorkThreadPool pool = new WorkThreadPool(handler, queueIn);
		pool.start(8);

		HttpServerResponse response = new HttpServerResponse(queueOut);
		response.start();
		
	}

}
