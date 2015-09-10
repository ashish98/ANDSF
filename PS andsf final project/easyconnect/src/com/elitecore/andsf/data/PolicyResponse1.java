package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class PolicyResponse1 {
	private Policy1 policy;
	private String resultCode;
	
	public PolicyResponse1(){
		this.resultCode="0001";
		
	}
	public Policy1 getPolicy() {
		return policy;
	}
	public void setPolicy(Policy1 policy) {
		this.policy = policy;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
//	@Override
//	public String toString() {
////		return "PolicyResponse [discoveryInformation=" + discoveryInformation
////				+ ", policy=" + policy + ", resultCode=" + resultCode + "]";
//	}
	
}
