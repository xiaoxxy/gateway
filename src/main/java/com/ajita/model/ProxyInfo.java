package com.ajita.model;

import com.ajita.slice.OpenApiPrx;

public class ProxyInfo {
	public String strProxy;
	public OpenApiPrx proxy;
	public boolean bValidFlag;

	public ProxyInfo() {
		this.proxy = null;
		this.bValidFlag = false;
	}
	
	public String getStrProxy() {
		return strProxy;
	}

	public void setStrProxy(String strProxy) {
		this.strProxy = strProxy;
	}

	public OpenApiPrx getProxy() {
		return proxy;
	}

	public void setProxy(OpenApiPrx proxy) {
		this.proxy = proxy;
	}

	public boolean isbValidFlag() {
		return bValidFlag;
	}

	public void setbValidFlag(boolean bValidFlag) {
		this.bValidFlag = bValidFlag;
	}

}
