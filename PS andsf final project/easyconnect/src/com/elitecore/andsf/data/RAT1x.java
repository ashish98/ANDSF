package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class RAT1x {
	
	@XmlElement
	public String NID;
	@XmlElement
	public String SID;
	@XmlElement
	public String base_ID;
	
	public String getNID() {
		return NID;
	}
	public void setNID(String nID) {
		NID = nID;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getBase_ID() {
		return base_ID;
	}
	public void setBase_ID(String base_ID) {
		this.base_ID = base_ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NID == null) ? 0 : NID.hashCode());
		result = prime * result + ((SID == null) ? 0 : SID.hashCode());
		result = prime * result + ((base_ID == null) ? 0 : base_ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RAT1x other = (RAT1x) obj;
		if (NID == null) {
			if (other.NID != null)
				return false;
		} else if (!NID.equals(other.NID))
			return false;
		if (SID == null) {
			if (other.SID != null)
				return false;
		} else if (!SID.equals(other.SID))
			return false;
		if (base_ID == null) {
			if (other.base_ID != null)
				return false;
		} else if (!base_ID.equals(other.base_ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RAT1x [NID=" + NID + ", SID=" + SID + ", base_ID=" + base_ID
				+ "]";
	}
	
	

}
