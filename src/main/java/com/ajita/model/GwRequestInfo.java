package com.ajita.model;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.http.api.HttpRequest;

public class GwRequestInfo {
	public IoSession session;
	public HttpRequest httpRequest;
	public long timestamp;

	public long getTimestramp() {
		return timestamp;
	}

	public void setTimestramp(long timestamp) {
		this.timestamp = timestamp;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public HttpRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

}
