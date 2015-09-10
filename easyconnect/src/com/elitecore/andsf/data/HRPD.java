package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class HRPD {
	
	@XmlElement
	public String netmask;
	@XmlElement
	public String sector_ID;
	
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public String getSector_ID() {
		return sector_ID;
	}
	public void setSector_ID(String sector_ID) {
		this.sector_ID = sector_ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((netmask == null) ? 0 : netmask.hashCode());
		result = prime * result
				+ ((sector_ID == null) ? 0 : sector_ID.hashCode());
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
		HRPD other = (HRPD) obj;
		if (netmask == null) {
			if (other.netmask != null)
				return false;
		} else if (!netmask.equals(other.netmask))
			return false;
		if (sector_ID == null) {
			if (other.sector_ID != null)
				return false;
		} else if (!sector_ID.equals(other.sector_ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HRPD [netmask=" + netmask + ", sector_ID=" + sector_ID + "]";
	}
	
}
