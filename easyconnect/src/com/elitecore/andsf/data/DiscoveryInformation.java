package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

public class DiscoveryInformation {
	
	//This will be always null.
	private AccessNetworkArea accessNetworkArea;
	private AccessNetworkInformationWLAN accessNetworkInformationWLAN;
	private int accessNetworkType;
	
	
	
	public AccessNetworkArea getAccessNetworkArea() {
		return accessNetworkArea;
	}
	public void setAccessNetworkArea(AccessNetworkArea accessNetworkArea) {
		this.accessNetworkArea = accessNetworkArea;
	}
	public AccessNetworkInformationWLAN getAccessNetworkInformationWLAN() {
		return accessNetworkInformationWLAN;
	}
	public void setAccessNetworkInformationWLAN(
			AccessNetworkInformationWLAN accessNetworkInformationWLAN) {
		this.accessNetworkInformationWLAN = accessNetworkInformationWLAN;
	}
	public int getAccessNetworkType() {
		return accessNetworkType;
	}
	public void setAccessNetworkType(int accessNetworkType) {
		this.accessNetworkType = accessNetworkType;
	}
	@Override
	public String toString() {
		return "DiscoveryInformation [accessNetworkArea=" + accessNetworkArea
				+ ", accessNetworkInformationWLAN="
				+ accessNetworkInformationWLAN + ", accessNetworkType="
				+ accessNetworkType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accessNetworkArea == null) ? 0 : accessNetworkArea
						.hashCode());
		result = prime
				* result
				+ ((accessNetworkInformationWLAN == null) ? 0
						: accessNetworkInformationWLAN.hashCode());
		result = prime * result + accessNetworkType;
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
		DiscoveryInformation other = (DiscoveryInformation) obj;
		if (accessNetworkArea == null) {
			if (other.accessNetworkArea != null)
				return false;
		} else if (!accessNetworkArea.equals(other.accessNetworkArea))
			return false;
		if (accessNetworkInformationWLAN == null) {
			if (other.accessNetworkInformationWLAN != null)
				return false;
		} else if (!accessNetworkInformationWLAN
				.equals(other.accessNetworkInformationWLAN))
			return false;
		if (accessNetworkType != other.accessNetworkType)
			return false;
		return true;
	}
	
	
	
	
}
