package com.ajita.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ajita.http.ServiceAgent;
import com.fasterxml.jackson.core.type.TypeReference;



public class Sync {

	public static int SyncAllData() {
		int ret = 0;
		if (((ret = SyncErrorListData()) != 0) || ((ret = SyncServiceListData()) != 0)) {
			return ret;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public synchronized static int SyncErrorListData() {
		String url = getUrlByTag("errorList");
		try {
			String response = HttpHelper.get(url, "utf-8");
			Map<String, Object> respMap = JsonHelper.fromJSON(response, new TypeReference<Map<String, Object>>() {
			});
			List<Map<String, Object>> errList = (ArrayList<Map<String, Object>>) (((Map<String, Object>) respMap
					.get("data")).get("errorList"));
			for (Map<String, Object> tmp : errList) {
				int result = (Integer) tmp.get("result");
				String detail = (String) tmp.get("detail");
				if (detail.isEmpty()) {
					detail = "unknow error,error no:" + result;
				}
				errorList_.put(result, detail);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	private static String getUrlByTag(String tag){
		if(tag == null || tag.equals(""))
			return "";
		Document configElement = ConfigParse.getRootElement();
		NodeList nodeList = configElement.getElementsByTagName(tag);
		Element item = (Element) nodeList.item(0);
		String url = item.getElementsByTagName("url").item(0).getTextContent().trim();
		return url;
	}
	
	public synchronized static int SyncServiceListData() {	
		String url = getUrlByTag("serviceList");
		try {
			String response = HttpHelper.get(url, "utf-8");
			Map<String, Object> respMap = JsonHelper.fromJSON(response, new TypeReference<Map<String, Object>>() {
			});
			
			for (String key : respMap.keySet()) {
				String[] vs = key.split("\\.");
				if(vs.length != 3)
					continue;
				Vector<String> groupNodeList = new Vector<String>();
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> dataList = (List<Map<String, Object>>) respMap.get(key);
				int count = dataList.size();
				for (int i = 0; i < count; i++) {
					Map<String, Object> map = dataList.get(i);
					String ip = (String)map.get("ip");
					String port = String.valueOf(map.get("port"));	
					String timeout =String.valueOf(map.get("timeout"));
					String os =  vs[vs.length-1] + ":tcp -h " + ip + " -p " + port + " -t "+ timeout;
					ServiceAgent.Instance().AddProxy(key, os);
					groupNodeList.add(os);						
				}
				ServiceAgent.ServiceGroup group = ServiceAgent.Instance().GetServiceGroup(key);
				if(group != null)
					group.CheckAndRemoveInvalidProxies(groupNodeList);
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	
	public static String GetErrorDetail(Integer errNo) {
		return errorList_.get(errNo);
	}

	public synchronized static int SyncLogServiceList() {
		String url = getUrlByTag("remoteLog");
		try {
			String response = HttpHelper.get(url, "utf-8");
			Map<String, Object> respMap = JsonHelper.fromJSON(response, new TypeReference<Map<String, Object>>() {
			});
			
			for (String key : respMap.keySet()) {
				String[] vs = key.split("\\.");
				if(vs.length != 3)
					continue;
			
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> dataList = (List<Map<String, Object>>) respMap.get(key);
				int count = dataList.size();
				for (int i = 0; i < count; i++) {
					Map<String, Object> map = dataList.get(i);
					String ip = (String)map.get("ip");
					String port = String.valueOf(map.get("port"));	
					String timeout =String.valueOf(map.get("timeout"));
					String os =  vs[vs.length-1] + ":tcp -h " + ip + " -p " + port + " -t "+ timeout;
					//  To Do
					//  RemoteLog::Instance()->AddLogServer(key,os.str());    
					Log.info(os);
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Map<Integer, String> errorList_ = new HashMap<Integer, String>();
	/*
	 * public static Map<String, List<Map<String, Object>>> serviceList_ = new HashMap<String, List<Map<String, Object>>>();
	 * public static Map<String, List<Map<String, Object>>> logServiceList_ = new HashMap<String, List<Map<String, Object>>>();
	*/
}
