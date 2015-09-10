package com.elitecore.andsf.data;

import java.util.Arrays;

import com.elitecore.andsf.data.circular.Geo_Location;

public class ValidityArea {
	 
	 private String RPLMN;
	 private WLAN_Location[] WLAN_Location;
	 private Geo_Location[] geo_Location_;
	 private Location_3GPP[] location_3GPP;
	 private Location_3GPP2[] location_3GPP2;
	 private WiMAX_Location[] wiMAX_Location;
	public String getRPLMN() {
		return RPLMN;
	}
	public void setRPLMN(String rPLMN) {
		RPLMN = rPLMN;
	}
	public WLAN_Location[] getWLAN_Location() {
		return WLAN_Location;
	}
	public void setWLAN_Location(WLAN_Location[] wLAN_Location) {
		WLAN_Location = wLAN_Location;
	}
	
	public Geo_Location[] getGeo_Location_() {
		return geo_Location_;
	}
	public void setGeo_Location_(Geo_Location[] geo_Location_) {
		this.geo_Location_ = geo_Location_;
	}
	public Location_3GPP[] getLocation_3GPP() {
		return location_3GPP;
	}
	public void setLocation_3GPP(Location_3GPP[] location_3gpp) {
		location_3GPP = location_3gpp;
	}
	public Location_3GPP2[] getLocation_3GPP2() {
		return location_3GPP2;
	}
	public void setLocation_3GPP2(Location_3GPP2[] location_3gpp2) {
		location_3GPP2 = location_3gpp2;
	}
	public WiMAX_Location[] getWiMAX_Location() {
		return wiMAX_Location;
	}
	public void setWiMAX_Location(WiMAX_Location[] wiMAX_Location) {
		this.wiMAX_Location = wiMAX_Location;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RPLMN == null) ? 0 : RPLMN.hashCode());
		result = prime * result + Arrays.hashCode(WLAN_Location);
		result = prime * result + Arrays.hashCode(geo_Location_);
		result = prime * result + Arrays.hashCode(location_3GPP);
		result = prime * result + Arrays.hashCode(location_3GPP2);
		result = prime * result + Arrays.hashCode(wiMAX_Location);
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
		ValidityArea other = (ValidityArea) obj;
		if (RPLMN == null) {
			if (other.RPLMN != null)
				return false;
		} else if (!RPLMN.equals(other.RPLMN))
			return false;
		if (!Arrays.equals(WLAN_Location, other.WLAN_Location))
			return false;
		if (!Arrays.equals(geo_Location_, other.geo_Location_))
			return false;
		if (!Arrays.equals(location_3GPP, other.location_3GPP))
			return false;
		if (!Arrays.equals(location_3GPP2, other.location_3GPP2))
			return false;
		if (!Arrays.equals(wiMAX_Location, other.wiMAX_Location))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ValidityArea [RPLMN=" + RPLMN + ", WLAN_Location="
				+ Arrays.toString(WLAN_Location) + ", geo_Location="
				+ Arrays.toString(geo_Location_) + ", location_3GPP="
				+ Arrays.toString(location_3GPP) + ", location_3GPP2="
				+ Arrays.toString(location_3GPP2) + ", wiMAX_Location="
				+ Arrays.toString(wiMAX_Location) + "]";
	}
	 
	 
     
     
     
}
