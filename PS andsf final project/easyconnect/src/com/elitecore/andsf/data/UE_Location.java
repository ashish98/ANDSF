package com.elitecore.andsf.data;

import java.util.Arrays;

import com.elitecore.andsf.data.ue_location.Geo_Location;

public class UE_Location {

	private String RPLMN;
	private WLAN_Location[] wlanLocation;
	private Geo_Location geoLocation;
	private Location_3GPP[] location_3gpp;
	private Location_3GPP2[] location_3gpp2;
	private WiMAX_Location[] wimaxLocation;
	
	
	public String getRPLMN() {
		return RPLMN;
	}
	public void setRPLMN(String rPLMN) {
		RPLMN = rPLMN;
	}
	public WLAN_Location[] getWlanLocation() {
		return wlanLocation;
	}
	public void setWlanLocation(WLAN_Location[] wlanLocation) {
		this.wlanLocation = wlanLocation;
	}
	public Geo_Location getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(Geo_Location geoLocation) {
		this.geoLocation = geoLocation;
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
	public WiMAX_Location[] getWimaxLocation() {
		return wimaxLocation;
	}
	public void setWimaxLocation(WiMAX_Location[] wimaxLocation) {
		this.wimaxLocation = wimaxLocation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RPLMN == null) ? 0 : RPLMN.hashCode());
		result = prime * result
				+ ((geoLocation == null) ? 0 : geoLocation.hashCode());
		result = prime * result + Arrays.hashCode(location_3gpp);
		result = prime * result + Arrays.hashCode(location_3gpp2);
		result = prime * result + Arrays.hashCode(wimaxLocation);
		result = prime * result + Arrays.hashCode(wlanLocation);
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
		UE_Location other = (UE_Location) obj;
		if (RPLMN == null) {
			if (other.RPLMN != null)
				return false;
		} else if (!RPLMN.equals(other.RPLMN))
			return false;
		if (geoLocation == null) {
			if (other.geoLocation != null)
				return false;
		} else if (!geoLocation.equals(other.geoLocation))
			return false;
		if (!Arrays.equals(location_3gpp, other.location_3gpp))
			return false;
		if (!Arrays.equals(location_3gpp2, other.location_3gpp2))
			return false;
		if (!Arrays.equals(wimaxLocation, other.wimaxLocation))
			return false;
		if (!Arrays.equals(wlanLocation, other.wlanLocation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UE_Location [RPLMN=" + RPLMN + ", wlanLocation="
				+ Arrays.toString(wlanLocation) + ", geoLocation="
				+ geoLocation + ", location_3gpp="
				+ Arrays.toString(location_3gpp) + ", location_3gpp2="
				+ Arrays.toString(location_3gpp2) + ", wimaxLocation="
				+ Arrays.toString(wimaxLocation) + "]";
	}
	
	
	
}
