package com.elitecorelib.andsf.validation;

import android.util.Log;

import com.elitecore.andsfparsing.utility.Utility;
import com.elitecorelib.andsf.api.DeviceDetail;
import com.elitecorelib.andsf.pojo.Circular;
import com.elitecorelib.andsf.pojo.Geo_Location_1;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.utility.CustomConstant;

public class GeoLocationValidator implements IValidationHandler{
	
	private IValidationHandler nextValidator;

	
	public void setNextValidator(IValidationHandler nextValidationHandler) {
		this.nextValidator = nextValidationHandler;
		
	}

	
	public int validate(Policy policy) {
		int validationStatus = CustomConstant.NOT_PROVIDED; 
		
		DeviceDetail devicelocation = DeviceDetail.getInstance();
		float devicelatitude = 0;
		float devicelongitude = 0;
		float locationlatitude = 0;
		float locationlongitude = 0;
		float radius = 0 ;
		
		
		
		if(policy.validityArea==null || policy.validityArea.geo_Location_==null || policy.validityArea.geo_Location_.isEmpty()){
			Log.d(CustomConstant.ApplicationTag,"GEO Locations is empty,so no need to validate GEO Location area.");
			validationStatus = CustomConstant.NOT_FOUND_IN_POLICY;
			return validationStatus;
		}
		
		if(devicelocation.getUeGeo_Location() == null){			
			Log.d(CustomConstant.ApplicationTag,"Device Geo Location Information is empty,so no need to validate Geo Location.");
			validationStatus = CustomConstant.NOT_FOUND_IN_UE;
			return validationStatus;			
		}
		
		for(Geo_Location_1  geoLocation_1: policy.validityArea.geo_Location_){
			
			if(geoLocation_1!=null && !geoLocation_1.isEmpty()){
				
				for(Circular wifiLocation : geoLocation_1){
										
					validationStatus = CustomConstant.NOT_MATCHED;
				
					if(wifiLocation.radius!=null && !"".equals(wifiLocation.radius) &&
							wifiLocation.latitude!=null && !"".equals(wifiLocation.latitude) &&
							wifiLocation.longitude!=null && !"".equals(wifiLocation.longitude) &&
							devicelocation.getUeGeo_Location().latitude!=null && !"".equals(devicelocation.getUeGeo_Location().latitude) &&
							devicelocation.getUeGeo_Location().longitude!=null && !"".equals(devicelocation.getUeGeo_Location().longitude) 
							){
						
						try{
							devicelatitude = Float.parseFloat(devicelocation.getUeGeo_Location().latitude);
							devicelongitude = Float.parseFloat(devicelocation.getUeGeo_Location().longitude);
							locationlatitude = Float.parseFloat(wifiLocation.latitude);
							locationlongitude = Float.parseFloat(wifiLocation.longitude);							
							radius = Float.parseFloat(wifiLocation.radius);
							
						}catch(NumberFormatException nfe){
							Log.e(CustomConstant.ApplicationTag,"Exception in parsing location attributes"+nfe,nfe);
							continue;
						}
						
						if(isValidLocation(devicelatitude, devicelongitude, locationlatitude, locationlongitude, radius)){
							validationStatus = CustomConstant.MATCHED;
							Log.d(CustomConstant.ApplicationTag,"Location is matched.");
							break;
						}
						
					}
															
				}
				
			}
			//To break Outer FOR loop
			if(validationStatus == CustomConstant.MATCHED){
				Log.d(CustomConstant.ApplicationTag,"UE Location is found with in valid HOTSPOT ,so skipping next geo locations specified into validity areas.");
				break;
			}
			
		}
								
		return validationStatus;
	}
	
	private boolean isValidLocation(double ueLatitude,double ueLongitude,double locationLatitude,double locationLongitude,double radius){
		boolean isWithinLocation = false;
		double distance = Utility.getDistanceBetweenLocations(ueLatitude, ueLongitude,locationLatitude, locationLongitude,'M');		
		
		if(distance<radius){
			isWithinLocation = true;
			Log.d(CustomConstant.ApplicationTag,"Device is with in specified locations distance:"+distance+" and radius:"+radius);
		}
		return isWithinLocation;
	}

}
