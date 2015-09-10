/**
 * 
 */
package com.elitecorelib.andsf.api;

import com.elitecorelib.andsf.pojo.ResponseObject;

/**
 * @author brijesh.mistry
 * Method for Pulling Policies.
 * Call PullPolicyRequest from Device when device neeed new Policies.
 *
 */
public interface IPolicyManager {
	
	public ResponseObject pullPolicy();
	

}
