package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

public class Policy1 {
	 public String PLMN;
     public int enable;
	public String getPLMN() {
		return PLMN;
	}
	public void setPLMN(String pLMN) {
		PLMN = pLMN;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
     
     
     
}
