package com.elitecore.andsf.data;

import java.util.Arrays;


public class PolicyResponse {
	@Override
	public String toString() {
		return "PolicyResponse [discoveryInformation="
				+ Arrays.toString(discoveryInformation) + ", policy="
				+ Arrays.toString(policy) + ", resultCode=" + resultCode + "]";
	}

	private DiscoveryInformation[] discoveryInformation;
	private Policy[] policy;
	private String resultCode;
	
	public PolicyResponse(){
		this.resultCode="0001";
		
	}

	public DiscoveryInformation[] getDiscoveryInformation() {
		return discoveryInformation;
	}

	public void setDiscoveryInformation(DiscoveryInformation[] discoveryInformation) {
		this.discoveryInformation = discoveryInformation;
	}

	public Policy[] getPolicy() {
		return policy;
	}

	public void setPolicy(Policy[] policy) {
		this.policy = policy;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	
}
