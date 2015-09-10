package com.elitecorelib.andsf.validation;

import android.util.Log;

import com.elitecorelib.andsf.api.DeviceDetail;
import com.elitecorelib.andsf.exception.InvalidDataException;
import com.elitecorelib.andsf.pojo.Location3GPP;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.utility.CustomConstant;

public class _3GPPLocationValidator implements IValidationHandler {

	private IValidationHandler nextValidator;
	
	
	public void setNextValidator(IValidationHandler nextValidationHandler) {
		this.nextValidator = nextValidationHandler;

	}

	
	public int validate(Policy policy) throws InvalidDataException {
		int validationStatus = CustomConstant.NOT_MATCHED;
		
		
		Log.d(CustomConstant.ApplicationTag,"3GPP validation started for Policy "+policy.validityArea);
				
		if(policy.validityArea==null || policy.validityArea.location_3GPP==null || policy.validityArea.location_3GPP.isEmpty()){
			Log.d(CustomConstant.ApplicationTag,"Validity Area or 3GPP Location is empty,so no need to validate 3GPP area.");
			validationStatus = CustomConstant.NOT_FOUND_IN_POLICY;
			return validationStatus;
		}
				
		
		DeviceDetail devicelocation = DeviceDetail.getInstance();
		if(devicelocation.getUe3GPPLocation()!=null){		
		
			if(policy.validityArea.location_3GPP != null && !policy.validityArea.location_3GPP.isEmpty()){
				for(Location3GPP location3gpp:policy.validityArea.location_3GPP){
					Log.d(CustomConstant.ApplicationTag,"Validation start for 3GPP Location "+location3gpp);
					location3gpp.validate();		
						
					Log.d(CustomConstant.ApplicationTag,"Device Location 3gpp matches with client 's locations .");
					/**
					 * Logic for 3GPP location validation
					 * Match PLMN ,If PLMN is matched then check for TAC,LAC,GERAN,EUTRAN or EUTRA,
					 * If any one of match then skip next check and return true.
					 *
					 */
					if(location3gpp.PLMN != null && location3gpp.PLMN.equals(devicelocation.getUe3GPPLocation().PLMN)){
						
						Log.d(CustomConstant.ApplicationTag," 3GPP Device Location :"+devicelocation.getUe3GPPLocation()+"\nPolicy 3GPP location: "+location3gpp);
						
						if(location3gpp.LAC!=null && location3gpp.LAC.equals(devicelocation.getUe3GPPLocation().LAC)){
							Log.d(CustomConstant.ApplicationTag," LAC is matched "+location3gpp.LAC);
							validationStatus = CustomConstant.MATCHED;							
							break;
						}
						
						if(location3gpp.TAC!=null && location3gpp.TAC.equals(devicelocation.getUe3GPPLocation().TAC)){
							Log.d(CustomConstant.ApplicationTag," TAC is matched "+location3gpp.TAC);
							validationStatus = CustomConstant.MATCHED;
							break;												
						}
						
						if(location3gpp.GERAN_CI!=null &&  location3gpp.GERAN_CI.equals(devicelocation.getUe3GPPLocation().GERAN_CI)){
							Log.d(CustomConstant.ApplicationTag," GERAN_CI is matched "+location3gpp.GERAN_CI);
							validationStatus = CustomConstant.MATCHED;
							break;
							
						}
						
						if(location3gpp.UTRAN_CI!=null && location3gpp.UTRAN_CI.equals(devicelocation.getUe3GPPLocation().UTRAN_CI)){
							Log.d(CustomConstant.ApplicationTag," UTRAN_CI is matched "+location3gpp.UTRAN_CI);
							validationStatus = CustomConstant.MATCHED;
							break;
							
						}
						
						if(location3gpp.EUTRA_CI!=null && location3gpp.EUTRA_CI.equals(devicelocation.getUe3GPPLocation().EUTRA_CI)){
							Log.d(CustomConstant.ApplicationTag," EUTRA is matched "+location3gpp.EUTRA_CI);							
							validationStatus = CustomConstant.MATCHED;
							break;							
						}
											
					}else{
						Log.d(CustomConstant.ApplicationTag," PLMN is diffrent or 3GPP location is not provided.");
						continue;
					}																										
				}
			}
		
		}else{
			Log.d(CustomConstant.ApplicationTag,"Current Device 3GPP Location is  not found,so skip device ");
			validationStatus = CustomConstant.NOT_FOUND_IN_UE;
		}
		
		
		return validationStatus;
	}

}
