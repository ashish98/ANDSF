package com.elitecore.andsfparsing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.elitecorelib.andsf.api.ANDSFRequest;
import com.elitecorelib.andsf.api.ANDSFTask;
import com.elitecorelib.andsf.api.ANDSFTaskListner;
import com.elitecorelib.andsf.api.GetPolicyRequest;
import com.elitecorelib.andsf.pojo.Geo_Location;
import com.elitecorelib.andsf.pojo.Location3GPP;
import com.elitecorelib.andsf.pojo.UeLocation;
import com.elitecorelib.andsf.utility.CustomConstant;

public class MainActivity extends Activity  implements ANDSFTaskListner{

	private Button btn_callANDSF;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_callANDSF=(Button)findViewById(R.id.btn_callANDSF);
		btn_callANDSF.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				ANDSFTask andsfTaskObj;

				Location3GPP gppLocation= new Location3GPP();
				gppLocation.EUTRA_CI="123";
				gppLocation.LAC="123456";

				UeLocation location=new UeLocation();
				location.location_3gpp.add(gppLocation);

				Geo_Location geoLocation=new Geo_Location();

				geoLocation.latitude="72.123";
				geoLocation.longitude="2.1239";
				location.geoLocation=geoLocation;



				GetPolicyRequest policyReq=new GetPolicyRequest();
				policyReq.setUe_Location(location);

				ANDSFRequest requestObj=new ANDSFRequest();
				requestObj.setPolicyRequestObj(policyReq);

				andsfTaskObj=new ANDSFTask(MainActivity.this, CustomConstant.ANDSF_SERVICE_GETPOLICYREQUEST,requestObj,"http://10.106.1.174:9090/easyconnect/services/ANDSFWebService?wsdl");
				andsfTaskObj.execute("");



			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onANDSFTaskComplete(Object result, int requestId) {
		// TODO Auto-generated method stub
		if(result!=null && requestId==CustomConstant.ANDSF_SERVICE_GETPOLICYREQUEST)
		{
			Log.d("ANDSF", result.toString());
		}
	}

}
