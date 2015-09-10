package com.elitecorelib.andsf.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

import android.util.Log;

import com.elitecorelib.andsf.exception.InvalidDataException;
import com.elitecorelib.andsf.pojo.DiscoveryInformation;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.pojo.PolicyResponse;
import com.elitecorelib.andsf.pojo.PrioritizedAccess;
import com.elitecorelib.andsf.utility.ANDSFConstant;
import com.elitecorelib.andsf.utility.CustomConstant;
import com.elitecorelib.andsf.validation.GeoLocationValidator;
import com.elitecorelib.andsf.validation.IValidationHandler;
import com.elitecorelib.andsf.validation.TimeOfDayValidator;
import com.elitecorelib.andsf.validation.WLanLocationValidator;
import com.elitecorelib.andsf.validation._3GPPLocationValidator;

public class PolicyImplementation {

	
	private static PolicyResponse policyResponse;
	private static Policy currentValidPolicy;
	private static int currentPolicyRulePriority;
	private static int currentValidPolicyId;
	private static String currentAccessId;	
	private static DiscoveryInformation  currentDiscoveryInformation;
	private static List<Integer> noAccessPolicyIdList=new ArrayList<Integer>();
	private static PrioritizedAccess currentPrioritizedAccess;
	private static List<String> noAccessIdList=new ArrayList<String>();
	private static int isSwitchOnDatabyPolicy = 0;  

	public static void setPolicyResponse(PolicyResponse polResponse){
		resetALL();
		policyResponse = polResponse;
//		evaluate();		
	}


	public static void evaluate() {
		
		
		
		List<PrioritizedAccess> accessIdList = null;
		
		Log.d(CustomConstant.ApplicationTag,"--------------Policy Validation started Here----------------------");
		findValidPolicy();
		Log.d(CustomConstant.ApplicationTag,"--------------Policy Validation ended Here----------------------");
		Log.d(CustomConstant.ApplicationTag,"--------------Current Valid Policy: "+currentValidPolicy);
		
		
		if(currentValidPolicy!=null){
			accessIdList = currentValidPolicy.prioritizedAccess;
			if(accessIdList!=null && !accessIdList.isEmpty()){
				
				Collections.sort(accessIdList);
				for(PrioritizedAccess prioritizedAccess:accessIdList){
					
					
					Log.d(CustomConstant.ApplicationTag,"policy Name "+currentValidPolicy.policyName+" Priritized Access "+prioritizedAccess);
					if(prioritizedAccess!=null){
						
						if(noAccessIdList!=null && !noAccessIdList.isEmpty() && noAccessIdList.contains(currentValidPolicyId+"_"+prioritizedAccess.accessId)){
						Log.d(CustomConstant.ApplicationTag,"As per last attempt to connect it is not available ,so skipping this prioritized access");	
							continue;
						}
						
						if(prioritizedAccess.accessNetworkPriority > 0 && prioritizedAccess.accessNetworkPriority < 250){
							if(prioritizedAccess.accessTechnology == ANDSFConstant.AccessTechnologyWLAN){
								currentAccessId = prioritizedAccess.accessId;
								findDiscoveryInformation();
								
								if(currentDiscoveryInformation!=null){
									Log.d(CustomConstant.ApplicationTag,"Current WLAN Connection attributes is:"+currentDiscoveryInformation.accessNetworkInformationWLAN);
									return;									
								}
								
							}else if(prioritizedAccess.accessTechnology == ANDSFConstant.AccessTechnology3GPP){
								isSwitchOnDatabyPolicy = 1;
								//Swith on Data Networks.
								
							}
						}else if(prioritizedAccess.accessNetworkPriority ==254 && prioritizedAccess.accessNetworkPriority ==255){
							if(prioritizedAccess.accessTechnology == ANDSFConstant.AccessTechnologyWLAN){
								findDiscoveryInformation();
								
								return;
								//Try to disconnect particular Connections
								
							}else if(prioritizedAccess.accessTechnology == ANDSFConstant.AccessTechnology3GPP){
								//Swith on Data Networks.
								//Switch of Data networks configured into devices
								isSwitchOnDatabyPolicy = 2;
								return;
							}
						}
						
					}
					
				}
				
				Log.d(CustomConstant.ApplicationTag,"Policy Donot have any valid Data network Connection and not found SSID also ");
				Log.d(CustomConstant.ApplicationTag,"Put it into Black List policy ");
				noAccessPolicyIdList.add(currentValidPolicyId);
				resetCurrentPolicy();
				evaluate();
				
				
			}else{
				
			}
									
		}else{
			Log.d(CustomConstant.ApplicationTag,"None of Valid ANDSF policy found into validity areas.");
		}
		
		
	}
	
	
	
	private static void findDiscoveryInformation() {
		Log.d(CustomConstant.ApplicationTag,"Find Discovery Information called for:"+currentAccessId );
		List<DiscoveryInformation> discoveryInformationList = policyResponse.discoveryInformation;
		
		if(discoveryInformationList != null && !discoveryInformationList.isEmpty() && currentAccessId!=null && !"".equals(currentAccessId)){
			
			for(DiscoveryInformation discoveryInformation:discoveryInformationList){
				if(discoveryInformation.accessNetworkInformationWLAN!=null && discoveryInformation.accessNetworkInformationWLAN.SSIDName!=null && discoveryInformation.accessNetworkInformationWLAN.SSIDName.equalsIgnoreCase(currentAccessId)){
					currentDiscoveryInformation = discoveryInformation;
					break;
				}
			}
			
		}
		
		Log.d(CustomConstant.ApplicationTag,"Current Discovery Informations:"+currentDiscoveryInformation);
	}


	public static void findValidPolicy(){
		//Sort Policy based on Priority
				List<Policy> policyList = policyResponse.policy;					
				if(policyList!=null && !policyList.isEmpty()){
					
					if(noAccessPolicyIdList!=null && noAccessPolicyIdList.isEmpty() && noAccessPolicyIdList.size() == policyList.size()){
						Log.d(CustomConstant.ApplicationTag,"There is no valid Policy is found ,so Skipping this check.");
						Log.d(CustomConstant.ApplicationTag,"All policy are invalid now.Total Invalid Policy:"+noAccessPolicyIdList.size());
						resetCurrentPolicy();
						return;						
					}
					
					Collections.sort(policyList);
					//Now iterate Policy once it is sorted		
					Log.d(CustomConstant.ApplicationTag,"No of Policy received."+policyList.size());
					
					for(Policy policy:policyList){
						
						
						
						if(noAccessPolicyIdList!=null && !noAccessPolicyIdList.isEmpty()  && policy!=null && noAccessPolicyIdList.contains(policy.policyId)){
							Log.d(CustomConstant.ApplicationTag,"This policy do not have valid data connections "+policy.policyName);							
							continue;
						}
						
						Log.d(CustomConstant.ApplicationTag,"Policy Name is "+policy.policyName);
						Log.d(CustomConstant.ApplicationTag,"Policy Id is "+policy.policyId);
						Log.d(CustomConstant.ApplicationTag,"Policy Rule Priority is "+policy.rulePriority);
						
						//Now checking for valid Policies.
						IValidationHandler timeOfdayValidator = new TimeOfDayValidator();
						int timeOfDayValidationStatus = CustomConstant.UNKNOWN;
						
						try {
							
							timeOfDayValidationStatus = timeOfdayValidator.validate(policy);
						
						} catch (InvalidDataException e) {
							Log.e(CustomConstant.ApplicationTag,"Exception while validating TimeOfDay Validator"+e,e);
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status :"+timeOfDayValidationStatus);
						
						if(timeOfDayValidationStatus == CustomConstant.NOT_MATCHED){
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						
						
						//3GPP validation started
						IValidationHandler _3ggpValidationHandler = new _3GPPLocationValidator();
						int _3gppValidationStatus = CustomConstant.UNKNOWN;
						
						try {
							
							_3gppValidationStatus = _3ggpValidationHandler.validate(policy);
						
						} catch (InvalidDataException e) {
							Log.e(CustomConstant.ApplicationTag,"Exception while validating 3GPP Validation "+e,e);
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into 3GPP Locations .");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for 3gpp :"+_3gppValidationStatus);
						
						if(_3gppValidationStatus == CustomConstant.NOT_MATCHED){
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						
						
						//WLAN validation started
						IValidationHandler wlanValidationHandler = new WLanLocationValidator();
						int wlanValidationStatus = CustomConstant.UNKNOWN;
						
						try {
							
							wlanValidationStatus = wlanValidationHandler.validate(policy);
						
						} catch (InvalidDataException e) {
							Log.e(CustomConstant.ApplicationTag,"Exception while validating Wlan Location validation "+e,e);
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into 3GPP Locations .");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for wlan :"+wlanValidationStatus);
						
						if(wlanValidationStatus == CustomConstant.NOT_MATCHED){
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Wlan.");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						
						
						//WLAN validation started
						IValidationHandler geoValidationHandler = new WLanLocationValidator();
						int geoValidationStatus = CustomConstant.UNKNOWN;
						
						try {
							
							geoValidationStatus = geoValidationHandler.validate(policy);
						
						} catch (InvalidDataException e) {
							Log.e(CustomConstant.ApplicationTag,"Exception while validating geo Location validation "+e,e);
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into geo Location .");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}
						
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for Geo :"+geoValidationStatus);
						
						if(geoValidationStatus == CustomConstant.NOT_MATCHED){
							Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into geo.");
							Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
							continue;
						}

						Log.d(CustomConstant.ApplicationTag,policy.policyName+" is valid Policy after validtion.");
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" now processing prioritized access.");
						
						currentValidPolicy = policy;
						currentValidPolicyId = policy.policyId;
						currentPolicyRulePriority = policy.rulePriority;
						
						Log.d(CustomConstant.ApplicationTag,policy.policyName+" NO Further Policy Validation.");
						break;
						
					}
					Log.d(CustomConstant.ApplicationTag," NO Further Policy Validation. Current valid Policy"+currentValidPolicy.policyName);															
				}
	}



	public static  DiscoveryInformation getCurrentValidDiscoveryInformation(){
		return currentDiscoveryInformation;
	}
	
	public static Policy getCurrentValidPolicy(){
		return currentValidPolicy;
	}
	
	public static void setPolicyStatus(int policyid,boolean status){
		if(!status){
			noAccessPolicyIdList.add(policyid);
		}
		resetCurrentPolicy();
	}

	public static void resetALL(){
		currentValidPolicy = null;;
		currentValidPolicyId = 0;
		currentPolicyRulePriority = 0;
		isSwitchOnDatabyPolicy = 0;
		currentDiscoveryInformation = null;
		noAccessIdList.clear();
		noAccessPolicyIdList.clear();
	}
	
	public static void resetCurrentPolicy(){
		currentValidPolicy = null;;
		currentValidPolicyId = 0;
		currentPolicyRulePriority = 0;
		currentDiscoveryInformation = null;
		isSwitchOnDatabyPolicy = 0;
	}
	
	
	public  static void addUnRechableSSID(String ssid){
		noAccessIdList.add(currentValidPolicyId+"_"+ssid);
	}
	
	public static boolean findValidPolicy(Policy policy){
		boolean ValidationStatus = false;					
						
		Log.d(CustomConstant.ApplicationTag,"Policy Name is "+policy.policyName);
		Log.d(CustomConstant.ApplicationTag,"Policy Id is "+policy.policyId);
		Log.d(CustomConstant.ApplicationTag,"Policy Rule Priority is "+policy.rulePriority);
		
		//Now checking for valid Policies.
		IValidationHandler timeOfdayValidator = new TimeOfDayValidator();
		int timeOfDayValidationStatus = CustomConstant.UNKNOWN;
		
		try {
			
			timeOfDayValidationStatus = timeOfdayValidator.validate(policy);
		
		} catch (InvalidDataException e) {
			Log.e(CustomConstant.ApplicationTag,"Exception while validating TimeOfDay Validator"+e,e);
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
		}
		
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status :"+timeOfDayValidationStatus);
		
		if(timeOfDayValidationStatus == CustomConstant.NOT_MATCHED){
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
			
		}
		
		
		
		//3GPP validation started
		IValidationHandler _3ggpValidationHandler = new _3GPPLocationValidator();
		int _3gppValidationStatus = CustomConstant.UNKNOWN;
		
		try {
			
			_3gppValidationStatus = _3ggpValidationHandler.validate(policy);
		
		} catch (InvalidDataException e) {
			Log.e(CustomConstant.ApplicationTag,"Exception while validating 3GPP Validation "+e,e);
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into 3GPP Locations .");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
		}
		
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for 3gpp :"+_3gppValidationStatus);
		
		if(_3gppValidationStatus == CustomConstant.NOT_MATCHED){
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Time of day.");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
			
		}
		
		
		
		//WLAN validation started
		IValidationHandler wlanValidationHandler = new WLanLocationValidator();
		int wlanValidationStatus = CustomConstant.UNKNOWN;
		
		try {
			
			wlanValidationStatus = wlanValidationHandler.validate(policy);
		
		} catch (InvalidDataException e) {
			Log.e(CustomConstant.ApplicationTag,"Exception while validating Wlan Location validation "+e,e);
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into 3GPP Locations .");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
			
		}
		
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for wlan :"+wlanValidationStatus);
		
		if(wlanValidationStatus == CustomConstant.NOT_MATCHED){
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into Wlan.");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;
			
		}
		
		
		
		//WLAN validation started
		IValidationHandler geoValidationHandler = new WLanLocationValidator();
		int geoValidationStatus = CustomConstant.UNKNOWN;
		
		try {
			
			geoValidationStatus = geoValidationHandler.validate(policy);
		
		} catch (InvalidDataException e) {
			Log.e(CustomConstant.ApplicationTag,"Exception while validating geo Location validation "+e,e);
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into geo Location .");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;			
		}
		
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" is validation Status for Geo :"+geoValidationStatus);
		
		if(geoValidationStatus == CustomConstant.NOT_MATCHED){
			Log.d(CustomConstant.ApplicationTag,policy.policyName+" is not valid policy due to Invalid data into geo.");
			Log.d(CustomConstant.ApplicationTag,"Evaluating Next policy");
			ValidationStatus =false;
			return ValidationStatus;			
		}

		Log.d(CustomConstant.ApplicationTag,policy.policyName+" is valid Policy after validtion.");
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" now processing prioritized access.");
				
		
		Log.d(CustomConstant.ApplicationTag,policy.policyName+" NO Further Policy Validation.");		
		ValidationStatus =true;
		return ValidationStatus;	
					
	}

	
}
