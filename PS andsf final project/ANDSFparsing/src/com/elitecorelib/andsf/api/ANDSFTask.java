package com.elitecorelib.andsf.api;

import android.os.AsyncTask;
import android.util.Log;

import com.elitecorelib.andsf.pojo.ANDSFWebServiceSoapBinding;
import com.elitecorelib.andsf.pojo.IServiceEvents;
import com.elitecorelib.andsf.utility.CustomConstant;

public class ANDSFTask   extends AsyncTask<String, Void, String> {


	private static final String MODULE = ANDSFTask.class.getSimpleName();
	private ANDSFTaskListner callback;
	private int requestId;
	private Object responseObject=null;
	private ANDSFRequest requestObject=null;
	//private PolicyResponse policyResponseObj=null;
	//private InitializeResponse initializeResponseObj=null;
	IServiceEvents serviceHandler = new WSCallbackHandler();
	//	private String url="http://10.106.1.45:8080/easyconnect/services/ANDSFWebService?wsdl";
	private String url;
	private ANDSFWebServiceSoapBinding service ;

	public ANDSFTask(ANDSFTaskListner callback,int requestId,ANDSFRequest requestObject,String url)
	{
		this.callback =callback;
		this.requestId= requestId;
		this.requestObject=requestObject;
		this.url=url;
		service = new ANDSFWebServiceSoapBinding(serviceHandler,this.url);

	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if(callback!=null)
		{
			try {

				callback.onANDSFTaskComplete(responseObject,requestId);	



			} catch (Exception e) {
				Log.d(MODULE, "Error during call back onTaskComplete");
			}	
		}

	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		try {

			if(requestId==CustomConstant.ANDSF_SERVICE_GETPOLICYREQUEST)
			{
				if(requestObject!=null && requestObject.getPolicyRequestObj()!=null)
				{
					//final String session,final String tag,final UeLocation ue_Location,final String HexToken,final String tz	
					responseObject=	service.GetPolicyRequest(requestObject.getPolicyRequestObj().getSession(), requestObject.getPolicyRequestObj().getTag(),requestObject.getPolicyRequestObj().getUe_Location(), requestObject.getPolicyRequestObj().getHexToken(), requestObject.getPolicyRequestObj().getTz());	 
				}

			}
			if(requestId==CustomConstant.ANDSF_SERVICE_INITIALIZEREQUEST)
			{
				//final String userName,final String password,final String IMEI,final String deviceType,final String IMSI,final String MSISDN,final String feature
				responseObject=service.InitializeRequest(requestObject.getInitializeReqObj().getUserName(), requestObject.getInitializeReqObj().getPassword(), requestObject.getInitializeReqObj().getIMEI(), requestObject.getInitializeReqObj().getDeviceType(), requestObject.getInitializeReqObj().getIMSI(), requestObject.getInitializeReqObj().getMSISDN(),requestObject.getInitializeReqObj().getFeature());		
			}	 


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
