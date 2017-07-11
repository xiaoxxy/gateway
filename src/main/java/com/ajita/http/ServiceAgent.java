package com.ajita.http;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

import com.ajita.common.Log;
import com.ajita.model.ProxyInfo;
import com.ajita.slice.OpenApiPrx;
import com.ajita.slice.OpenApiPrxHelper;


public class ServiceAgent extends Thread {

	Ice.Communicator _communicator = null;
	static ServiceAgent _pAgent = null;
	private Map<String, ServiceGroup> _proxieGroups = new HashMap<String, ServiceGroup>();
	private boolean m_bExit;

	public ServiceAgent() {
		this.m_bExit = false;
		if (_communicator == null) {
			Ice.Properties beforeProperties = Ice.Util.createProperties();
			beforeProperties.setProperty("Ice.MessageSizeMax", "4096");
			Ice.InitializationData initData = new Ice.InitializationData();
			initData.properties = beforeProperties;
			_communicator = Ice.Util.initialize(initData);
		}
	}

	public synchronized boolean AddProxy(String strGroup, String strProxy) {
		if (strGroup.isEmpty())
			return false;

		ServiceGroup group = _proxieGroups.get(strGroup);
		if (group == null) {
			group = new ServiceGroup(strGroup);
			_proxieGroups.put(strGroup, group);
		}

		return group.AddProxy(strProxy);
	}

	public synchronized boolean SetServiceId(String strGroup, int iServiceId) {

		if (strGroup.isEmpty())
			return false;

		ServiceGroup group = _proxieGroups.get(strGroup);
		if (group == null) {
			group = new ServiceGroup(strGroup);
			_proxieGroups.put(strGroup, group);
		}
		group.setServiceId(iServiceId);

		return true;
	}

	public synchronized void SetProxyInvalid(String strGroup, OpenApiPrx proxy) {

		ServiceGroup group = _proxieGroups.get(strGroup);
		if (group == null) {
			return;
		}
		group.SetProxyInvalid(proxy);
	}

	public synchronized int GetServiceId(String strGroup) {
		ServiceGroup group = _proxieGroups.get(strGroup);
		return group == null ? 0 : group.getServiceId();
	}

	public synchronized ServiceGroup GetServiceGroup(String strGroup) {
		return _proxieGroups.get(strGroup);
	}

	public OpenApiPrx GetProxy(String strGroup) {
		ServiceGroup group = _proxieGroups.get(strGroup);
		return group != null ? group.GetProxy() : null;
	}

	public static ServiceAgent Instance() {
		return _pAgent;
	}

	public static void Instance(ServiceAgent pAgent) {
		_pAgent = pAgent;
	}

	public synchronized Map<String, ServiceGroup> GetGroups() {
		return _proxieGroups;
	}

	@Override
	public void run() {

		while (!m_bExit) {
			Map<String, ServiceGroup> groups = GetGroups();
			// 采用Iterator遍历HashMap
			Iterator<String> it = groups.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				ServiceGroup group = groups.get(key);
				if (group == null)
					continue;
				group.CheckValid();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.info("agent exit success!");
	}

	public void cancel() {
		this.m_bExit = true;
	}

	// ************************* Inner Class *******************************
	public class ServiceGroup {
		private String name;
		private LinkedList<ProxyInfo> proxies;
		private int serviceId;
		private volatile int serviceIndex;

		public ServiceGroup(String name) {
			this.name = name;
			this.serviceId = 0;
			serviceIndex = 0;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public synchronized LinkedList<ProxyInfo> getProxies() {
			return proxies;
		}

		public synchronized void setProxies(LinkedList<ProxyInfo> proxies) {
			this.proxies = proxies;
		}

		public int getServiceId() {
			return serviceId;
		}

		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}

		public int getServiceIndex() {
			return serviceIndex;
		}

		public void setServiceIndex(int serviceIndex) {
			this.serviceIndex = serviceIndex;
		}

		public synchronized boolean AddProxy(String strProxy) {
			for (int i = 0; i < proxies.size(); i++) {
				if (proxies.get(i).strProxy == strProxy) {
					return false;
				}
			}

			ProxyInfo proxyInfo = new ProxyInfo();

			Ice.ObjectPrx base = _communicator.stringToProxy(strProxy);
			OpenApiPrx proxy = OpenApiPrxHelper.checkedCast(base);

			if (proxy == null) {
				proxyInfo.proxy = null;
				proxyInfo.bValidFlag = false;

			} else {
				proxyInfo.strProxy = strProxy;
				proxyInfo.bValidFlag = true;
			}

			proxies.add(proxyInfo);
			Log.info("service group(" + name + ") addproxy: " + strProxy);
			return true;
		}

		public synchronized void SetProxyInvalid(OpenApiPrx proxy) {
			for (int i = 0; i < proxies.size(); i++) {
				if (proxies.get(i).proxy == proxy) {
					ProxyInfo info = proxies.get(i);
					info.setbValidFlag(false);
					proxies.set(i, info);
					Log.warn("agent"+proxies.get(i).getStrProxy()+" has go away!");
					break;
				}
			}
		}

		public synchronized OpenApiPrx GetProxy() {
			if (proxies.size() == 0)
				return null;
			// 轮询策略
			int size = proxies.size();
			serviceIndex++;
			serviceIndex = serviceIndex % size;

			ProxyInfo proxyInfo = proxies.get(serviceIndex);
			OpenApiPrx proxy = proxyInfo.getProxy();
			if (proxy != null && proxyInfo.isbValidFlag()) {
				return proxy;
			}
			// 找一个有效的
			for (int i = 0; i < size; i++) {
				if (proxies.get(i).getProxy() != null && proxyInfo.isbValidFlag())
					return proxies.get(i).getProxy();
			}
			Log.info("service(" + name + ") has shutdown!");
			return null;
		}

		public void CheckValid() {		
			LinkedList<ProxyInfo> 	proxyInfos = getProxies();
			
			for (int i = 0; i < proxyInfos.size(); i++) {
				try {
					if (proxyInfos.get(i).getProxy() == null) {
						Ice.ObjectPrx base = _communicator.stringToProxy(proxyInfos.get(i).getStrProxy());
						OpenApiPrx proxy = OpenApiPrxHelper.checkedCast(base);
						BindProxy(proxyInfos.get(i).getStrProxy(), proxy);
					} else {
						proxyInfos.get(i).getProxy().ice_ping();
						if (!proxyInfos.get(i).isbValidFlag()) {
							BindProxy(proxyInfos.get(i).getStrProxy(), proxyInfos.get(i).getProxy());
							Log.info(proxyInfos.get(i).getStrProxy()+" resume normal.");
						}
					}
				} catch (Exception e) {
					if (proxyInfos.get(i).isbValidFlag())
						UnBindProxy(proxyInfos.get(i).getStrProxy(), proxyInfos.get(i).getProxy());
					System.err
							.println("Proxy " + proxyInfos.get(i).getStrProxy() + " exception info:" + e.getMessage());
				}
			}

		}

		public synchronized void BindProxy(String strProxy, OpenApiPrx proxy) {
			for (int i = 0; i < proxies.size(); i++) {
				if (proxies.get(i).strProxy == strProxy) {
					ProxyInfo info = proxies.get(i);
					info.proxy = proxy;
					info.bValidFlag = true;
					proxies.set(i, info);
					return;
				}
			}
		}

		public synchronized void UnBindProxy(String strProxy, OpenApiPrx proxy) {
			for (int i = 0; i < proxies.size(); i++) {
				if (proxies.get(i).strProxy == strProxy) {
					ProxyInfo info = proxies.get(i);
					info.proxy = proxy;
					info.bValidFlag = false;
					proxies.set(i, info);
					return;
				}
			}
		}

		public synchronized LinkedList<ProxyInfo> GetServiceList() {
			LinkedList<ProxyInfo> lst = new LinkedList<ProxyInfo>();
			for (int i = 0; i < proxies.size(); i++) {
				if (proxies.get(i).bValidFlag)
					lst.add(proxies.get(i));
			}
			return lst;
		}

		public synchronized void CheckAndRemoveInvalidProxies(Vector<String> v_proxies) {

			Iterator<ProxyInfo> it = proxies.iterator();
			while (it.hasNext()) {
				ProxyInfo proxy = it.next();
				boolean find = false;

				for (int j = 0; j < v_proxies.size(); j++) {
					if (proxy.strProxy.equals(v_proxies.elementAt(j)))
						continue;
					find = true;
					break;
				}

				if (find)
					continue;
				else
					it.remove();
			}
		}
	}

}
