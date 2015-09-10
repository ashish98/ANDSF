package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name="WLAN_Location", namespace="urn:test")
@XmlAccessorType(XmlAccessType.FIELD)
public class WLAN_Location {
	
	@XmlElement
	public String BSSID;
	@XmlElement
	public String HESSID;
	@XmlElement
	public String SSID;
	
	public String getBSSID() {
		return BSSID;
	}
	public void setBSSID(String bSSID) {
		BSSID = bSSID;
	}
	public String getHESSID() {
		return HESSID;
	}
	public void setHESSID(String hESSID) {
		HESSID = hESSID;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BSSID == null) ? 0 : BSSID.hashCode());
		result = prime * result + ((HESSID == null) ? 0 : HESSID.hashCode());
		result = prime * result + ((SSID == null) ? 0 : SSID.hashCode());
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
		WLAN_Location other = (WLAN_Location) obj;
		if (BSSID == null) {
			if (other.BSSID != null)
				return false;
		} else if (!BSSID.equals(other.BSSID))
			return false;
		if (HESSID == null) {
			if (other.HESSID != null)
				return false;
		} else if (!HESSID.equals(other.HESSID))
			return false;
		if (SSID == null) {
			if (other.SSID != null)
				return false;
		} else if (!SSID.equals(other.SSID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WLAN_Location [BSSID=" + BSSID + ", HESSID=" + HESSID
				+ ", SSID=" + SSID + "]";
	}
	
	
	
}
