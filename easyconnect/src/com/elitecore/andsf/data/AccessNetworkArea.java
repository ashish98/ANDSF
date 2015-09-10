package com.elitecore.andsf.data;

import java.util.Arrays;

import com.elitecore.andsf.data.circular.Geo_Location;

public class AccessNetworkArea {
	
	private WLAN_Location[] wlan_Location;
	private Geo_Location geo_Location_;
	private Location_3GPP[] location_3gpp;
	private Location_3GPP2[] location_3gpp2;
	private WiMAX_Location[] wimMax_Location;
	
	

	public WLAN_Location[] getWlan_Location() {
		return wlan_Location;
	}
	public void setWlan_Location(WLAN_Location[] wlan_Location) {
		this.wlan_Location = wlan_Location;
	}

	public Geo_Location getGeo_Location_() {
		return geo_Location_;
	}
	public void setGeo_Location_(Geo_Location geo_Location_) {
		this.geo_Location_ = geo_Location_;
	}
	public Location_3GPP[] getLocation_3gpp() {
		return location_3gpp;
	}
	public void setLocation_3gpp(Location_3GPP[] location_3gpp) {
		this.location_3gpp = location_3gpp;
	}
	public Location_3GPP2[] getLocation_3gpp2() {
		return location_3gpp2;
	}
	public void setLocation_3gpp2(Location_3GPP2[] location_3gpp2) {
		this.location_3gpp2 = location_3gpp2;
	}
	public WiMAX_Location[] getWimMax_Location() {
		return wimMax_Location;
	}
	public void setWimMax_Location(WiMAX_Location[] wimMax_Location) {
		this.wimMax_Location = wimMax_Location;
	}	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((geo_Location_ == null) ? 0 : geo_Location_.hashCode());
		result = prime * result + Arrays.hashCode(location_3gpp);
		result = prime * result + Arrays.hashCode(location_3gpp2);
		result = prime * result + Arrays.hashCode(wimMax_Location);
		result = prime * result + Arrays.hashCode(wlan_Location);
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
		AccessNetworkArea other = (AccessNetworkArea) obj;
		if (geo_Location_ == null) {
			if (other.geo_Location_ != null)
				return false;
		} else if (!geo_Location_.equals(other.geo_Location_))
			return false;
		if (!Arrays.equals(location_3gpp, other.location_3gpp))
			return false;
		if (!Arrays.equals(location_3gpp2, other.location_3gpp2))
			return false;
		if (!Arrays.equals(wimMax_Location, other.wimMax_Location))
			return false;
		if (!Arrays.equals(wlan_Location, other.wlan_Location))
			return false;
		return true;
	}
	
}
