package com.ajita.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.http.api.DefaultHttpResponse;
import org.apache.mina.http.api.HttpResponse;
import org.apache.mina.http.api.HttpStatus;
import org.apache.mina.http.api.HttpVersion;

import com.ajita.common.WorkQueue;
import com.ajita.model.GwResponseInfo;

public class HttpServerResponse extends Thread {
	private WorkQueue<Object> m_queueOut;
	private boolean m_bExit;
	
	public HttpServerResponse(WorkQueue<Object> queueOut){
		this.m_bExit = false;
		this.m_queueOut = queueOut;
	}
	
	@Override
	public void run() {
		while (!m_bExit) {
			try {
				messageResponse();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void cancel() {
		this.m_bExit = true;
	}
	
	// 响应HTML
	private void messageResponse() throws InterruptedException {
		GwResponseInfo info = (GwResponseInfo) m_queueOut.get();
		System.out.println("--- Process  [queueOut]!  ---");
		// CHttpServer::SendData()
		String result = info.httpResponse;
		if (result == null)
			result = "";

		byte[] responseBytes;
		try {
			responseBytes = result.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			responseBytes = result.getBytes();
			e.printStackTrace();
		}
		int contentLength = responseBytes.length;

		// 构造HttpResponse对象，HttpResponse只包含响应的status line和header部分
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "text/html; charset=utf-8");
		headers.put("Content-Length", Integer.toString(contentLength));
		HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SUCCESS_OK, headers);

		// 响应的BODY体
		IoBuffer responseIoBuffer = IoBuffer.allocate(contentLength);
		responseIoBuffer.put(responseBytes);
		responseIoBuffer.flip();

		// 响应的status line和header部分
		info.session.write(response);
		// 响应body部分
		info.session.write(responseIoBuffer);
	}
	
}
