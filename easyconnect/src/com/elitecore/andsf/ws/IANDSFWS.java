package com.elitecore.andsf.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.elitecore.andsf.data.InitializeResponse;
import com.elitecore.andsf.data.PolicyResponse;
import com.elitecore.andsf.data.UE_Location;

@WebService(name = "ANDSFWebService")
public interface IANDSFWS {
	
	
	@WebMethod(operationName="InitializeRequest")
	@WebResult(name="InitializeResponse")
	public InitializeResponse InitializeRequest(@WebParam(name="userName")  String username,@WebParam(name="password") String password,@WebParam(name="IMEI") String IMEI,@WebParam(name="deviceType") String deviceType,@WebParam(name="IMSI") String IMSI,@WebParam(name="MSISDN") String MSISDN,@WebParam(name="feature") String feature);
	
	
	@WebMethod(operationName="GetPolicyRequest" )
	@WebResult(name="PolicyResponse" )
	public PolicyResponse GetPolicyRequest(@WebParam(name="session") String session,@WebParam(name="tag") String tag,@WebParam(name="ue_Location") UE_Location ue_Location,@WebParam(name="HexToken") String HexToken, @WebParam(name="tz") String tz);
	
	@WebMethod(operationName="GetSampleRequest")
	@WebResult(name="String" )
	public String GetSampleRequest(@WebParam(name="param1") String param1);
}