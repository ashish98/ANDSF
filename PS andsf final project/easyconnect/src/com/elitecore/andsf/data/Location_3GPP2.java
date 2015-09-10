package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location_3GPP2 {
	
	@XmlElement
	public HRPD hrpd;
	@XmlElement
	public RAT1x rat1x;
	
	public HRPD getHrpd() {
		return hrpd;
	}
	public void setHrpd(HRPD hrpd) {
		this.hrpd = hrpd;
	}
	public RAT1x getRat1x() {
		return rat1x;
	}
	public void setRat1x(RAT1x rat1x) {
		this.rat1x = rat1x;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hrpd == null) ? 0 : hrpd.hashCode());
		result = prime * result + ((rat1x == null) ? 0 : rat1x.hashCode());
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
		Location_3GPP2 other = (Location_3GPP2) obj;
		if (hrpd == null) {
			if (other.hrpd != null)
				return false;
		} else if (!hrpd.equals(other.hrpd))
			return false;
		if (rat1x == null) {
			if (other.rat1x != null)
				return false;
		} else if (!rat1x.equals(other.rat1x))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location_3GPP2 [hrpd=" + hrpd + ", rat1x=" + rat1x + "]";
	}
	

}
