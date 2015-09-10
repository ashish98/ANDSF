package com.elitecorelib.andsf.api;

import com.elitecorelib.andsf.pojo.ANDSFWebServiceSoapBinding;
import com.elitecorelib.andsf.pojo.IServiceEvents;

final class WsClient {

	IServiceEvents serviceHandler = new WSCallbackHandler();
	private String url="http://10.106.1.45:8080/easyconnect/services/ANDSFWebService";
	private ANDSFWebServiceSoapBinding service = new ANDSFWebServiceSoapBinding(serviceHandler,url);
	
	
	
	
	
}
