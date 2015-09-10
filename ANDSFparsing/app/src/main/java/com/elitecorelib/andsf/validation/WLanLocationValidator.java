package com.elitecorelib.andsf.validation;

import android.util.Log;

import com.elitecorelib.andsf.api.DeviceDetail;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.pojo.UeLocation;
import com.elitecorelib.andsf.pojo.WlanLocation;
import com.elitecorelib.andsf.utility.CustomConstant;

public class WLanLocationValidator implements IValidationHandler {

	private IValidationHandler nextValidator;
	
	@Override
	public void setNextValidator(IValidationHandler nextValidationHandler) {
		this.nextValidator = nextValidationHandler;

	}

	@Override
	public int validate(Policy policy) {
		
		int validationStatus = CustomConstant.NOT_MATCHED;
		DeviceDetail devicelocation = DeviceDetail.getInstance();
		
		
		Log.d(CustomConstant.ApplicationTag,"WLAN Location validation started for Policy "+policy.validityArea.WLAN_Location);
						
		if(policy.validityArea==null || policy.validityArea.WLAN_Location==null || policy.validityArea.WLAN_Location.isEmpty()){
			Log.d(CustomConstant.ApplicationTag,"WLAN Location is empty,so no need to validate WLAN area.");
			validationStatus = CustomConstant.NOT_FOUND_IN_POLICY;
			return validationStatus;
		}
		
		if(devicelocation.getUeWlanLocation() == null){
			Log.d(CustomConstant.ApplicationTag,"Device WLAN Information is empty,so no need to validate WLAN area.");
			validationStatus = CustomConstant.NOT_FOUND_IN_UE;
			return validationStatus;
		}
		
		for(WlanLocation wlanLocation : policy.validityArea.WLAN_Location){
			
			if(wlanLocation.BSSID != null && !"".equals(wlanLocation.BSSID) && devicelocation.getUeWlanLocation().BSSID.equals(wlanLocation.BSSID)){
				Log.d(CustomConstant.ApplicationTag," WLAN Validation BSSID tag is matched"+wlanLocation.BSSID);
				validationStatus = CustomConstant.MATCHED;
				break;			
			}
			if(wlanLocation.SSID != null && !"".equals(wlanLocation.SSID) && devicelocation.getUeWlanLocation().SSID.equals(wlanLocation.SSID)){
				Log.d(CustomConstant.ApplicationTag," WLAN Validation SSID tag is matched"+wlanLocation.SSID);
				validationStatus = CustomConstant.MATCHED;				
				break;
			}
			
			if(wlanLocation.HESSID != null && !"".equals(wlanLocation.HESSID) && devicelocation.getUeWlanLocation().HESSID.equals(wlanLocation.HESSID)){
				Log.d(CustomConstant.ApplicationTag," WLAN Validation HESSID tag is matched"+wlanLocation.HESSID);				
				validationStatus = CustomConstant.MATCHED;
				break;				
			}			
		}
																
		return validationStatus;
	}

}
