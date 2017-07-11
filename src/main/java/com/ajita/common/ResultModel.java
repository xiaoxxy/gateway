package com.ajita.common;

public class ResultModel {
	private int result;
	private String detail;

	private Object data;

	public ResultModel() {
		detail = "ok";
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setResultAndDetail(int result, String detail) {
		this.detail = detail;
		this.result = result;
		this.data = null;
	}

	@SuppressWarnings("unchecked")
	public <T> T getData() {
		return (T) data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void init() {
		result = 0;
		detail = "ok";
		data = null;
	}


}
