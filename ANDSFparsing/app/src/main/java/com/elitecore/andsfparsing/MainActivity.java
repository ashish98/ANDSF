package com.elitecore.andsfparsing;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import com.elitecorelib.andsf.pojo.PolicyInformation;
import com.elitecorelib.andsf.pojo.PolicyResponse;
import com.elitecorelib.andsf.pojo.UeLocation;
import com.elitecorelib.andsf.utility.CustomConstant;

public class MainActivity extends Activity implements ANDSFTaskListner {

	private Button btn_callANDSF;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_callANDSF = (Button) findViewById(R.id.btn_callANDSF);
		btn_callANDSF.setOnClickListener(new OnClickListener() {

			UeLocation location = new UeLocation();
			Geo_Location geoLocation1 = new Geo_Location();

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				ANDSFTask andsfTaskObj;

				Location3GPP gppLocation = new Location3GPP();
				gppLocation.EUTRA_CI = "123";
				gppLocation.LAC = "123456";

				// UeLocation location = new UeLocation();
				location.location_3gpp.add(gppLocation);
				/*
				try {
					LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
					Location lastLocation = lm
							.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					if (lastLocation != null) {
						geoLocation1.latitude = Double.toString(lastLocation
								.getLatitude());
						geoLocation1.longitude = Double.toString(lastLocation
								.getLongitude());
					}
				}
				catch (Exception e)
				{
					Log.d("MSG",e.getMessage());
				}
				// Geo_Location geoLocation = new Geo_Location();

				LocationListener ll = new myLocationListener();
				location.geoLocation = geoLocation1; */

				GetPolicyRequest policyReq = new GetPolicyRequest();
				policyReq.setUe_Location(location);

				ANDSFRequest requestObj = new ANDSFRequest();
				requestObj.setPolicyRequestObj(policyReq);

				andsfTaskObj = new ANDSFTask(MainActivity.this,
						CustomConstant.ANDSF_SERVICE_GETPOLICYREQUEST,
						requestObj,
						"http://10.116.1.118:9090/easyconnect/services/ANDSFWebService?wsdl");
				andsfTaskObj.execute("");

			}
/*
			class myLocationListener implements LocationListener {

				@Override
				public void onLocationChanged(Location locate) {
					if (locate != null) {
						double plat = locate.getLatitude();
						double plong = locate.getLongitude();

						geoLocation1.latitude = Double.toString(plat);
						geoLocation1.longitude = Double.toString(plong);
						location.geoLocation = geoLocation1;
					}

				}

				@Override
				public void onProviderDisabled(String provider) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onProviderEnabled(String provider) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onStatusChanged(String provider, int status,
						Bundle extras) {
					// TODO Auto-generated method stub

				}}
*/

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
		if (result != null
				&& requestId == CustomConstant.ANDSF_SERVICE_GETPOLICYREQUEST) {
			PolicyResponse resObj = (PolicyResponse) result;
			PolicyInformation.getPolicyInformation().evaluatePolicy(
					resObj.policy);
			Log.d("ANDSF", result.toString());
		}
	}

}
