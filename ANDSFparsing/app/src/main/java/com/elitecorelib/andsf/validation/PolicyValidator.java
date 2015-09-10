package com.elitecorelib.andsf.validation;

import com.elitecorelib.andsf.api.DeviceDetail;
import com.elitecorelib.andsf.pojo.Policy;


/**
 * Check various Policy Validation and its criteria into Policy Validation
 * @author brijesh.mistry
 *
 */
public class PolicyValidator {
	

	private Policy policy;
	
	private DeviceDetail deviceInfo;

	PolicyValidator(Policy policy, DeviceDetail deviceInfo) {
	
		this.policy = policy;
		this.deviceInfo = deviceInfo;
	}
	
	
	boolean validatePolicy(){
		boolean validationStatus = false;
		
		
		return validationStatus;			
	}

	
}
