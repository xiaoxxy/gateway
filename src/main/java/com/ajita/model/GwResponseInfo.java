package com.ajita.model;

import org.apache.mina.core.session.IoSession;

public class GwResponseInfo {
	public IoSession session;
	public String httpResponse;

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public String getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(String httpResponse) {
		this.httpResponse = httpResponse;
	}

}
