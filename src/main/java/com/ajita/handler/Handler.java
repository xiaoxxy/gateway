package com.ajita.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajita.common.Constant;
import com.ajita.common.JsonHelper;
import com.ajita.common.Log;
import com.ajita.common.ResultModel;
import com.ajita.common.Util;
import com.ajita.common.WorkQueue;
import com.ajita.http.ServiceAgent;
import com.ajita.model.GwRequestInfo;
import com.ajita.model.GwResponseInfo;
import com.ajita.slice.OpenApiPrx;

import Ice.StringHolder;



public class Handler {
	private WorkQueue<Object> m_queueOut;
	
	//@Autowired
    //private MsRPCProxy rpcProxy;

	public Handler(WorkQueue<Object> queueOut) {
		this.m_queueOut = queueOut;
	}
		
	// 从WorkQueue中取HttpRequest pkt，进行ice调用
	@SuppressWarnings("unused")
	public int OnPacket(Object obj) throws InterruptedException {
		ResultModel resultModel = new ResultModel();
		String result = "";
		
		GwRequestInfo request = (GwRequestInfo) obj;
		if(Util.currentTimestamp() - request.getTimestramp() > Constant.REQUEST_TIMEOUT){
			resultModel.setResult(Constant.E_TIMEOUT);
			resultModel.setDetail(Util.getDetail(Constant.E_TIMEOUT));
			return HandlePacket( request,  JsonHelper.toJSON(resultModel));
		}
		
		String path = request.getHttpRequest().getRequestPath();
		if (path != null && path.equals("/favicon.ico"))
		{
			resultModel.setDetail("");
			return HandlePacket( request,  JsonHelper.toJSON(resultModel));
		}
		
		OpenApiPrx verifyPtr = ServiceAgent.Instance().GetProxy("weizhi.cloud.auth");
		if ( verifyPtr == null )
		{
			Log.error("weizhi.cloud.auth service not found");
			resultModel.setResult(Constant.E_SERVICENOTFOUND);
			resultModel.setDetail(Util.getDetail(Constant.E_SERVICENOTFOUND));
			return HandlePacket( request,  JsonHelper.toJSON(resultModel));
		}
		
		
		Map<String, List<String>> parameters = request.getHttpRequest().getParameters();
		Map<String, String> param = new HashMap<String, String>();
		for(String key : parameters.keySet()){
			List<String> list = parameters.getOrDefault(key, null);	
			String value = list !=null ? list.get(0) : "";	
			param.put(key, value);
		}
		Log.info(parameters.toString());
		StringHolder holder = null;
		verifyPtr.microseerRequest(param, holder);
		if(holder != null)
			result = holder.value;
		//result = rpcProxy.invoke("weizhi.cloud.auth", param);	
		
		// result is json style
		resultModel.setDetail(result);	
		
		// ... Call concrete business process ... 
		result = JsonHelper.toJSON(resultModel);
		
		HandlePacket( request,  result);		
		return 0;
	}
	
	// set session and response, push HTTP Response to work queue
	private int HandlePacket(GwRequestInfo request, String result){
		GwResponseInfo response = new GwResponseInfo();
		response.setSession(request.getSession());
		response.setHttpResponse(result);		
		System.out.println("--- Push data into [ queueOut ]! ---size of  queueIn: ---" + m_queueOut.size());
		if(m_queueOut.put(response))
			return 0;
		else
			return -1;
	}
	
	
	
}
