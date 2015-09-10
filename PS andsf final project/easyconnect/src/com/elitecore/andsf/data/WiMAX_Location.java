package com.elitecore.andsf.data;

public class WiMAX_Location {
	private String BS_ID;
	private String NAP_ID;
	public String getBS_ID() {
		return BS_ID;
	}
	public void setBS_ID(String bS_ID) {
		BS_ID = bS_ID;
	}
	public String getNAP_ID() {
		return NAP_ID;
	}
	public void setNAP_ID(String nAP_ID) {
		NAP_ID = nAP_ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BS_ID == null) ? 0 : BS_ID.hashCode());
		result = prime * result + ((NAP_ID == null) ? 0 : NAP_ID.hashCode());
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
		WiMAX_Location other = (WiMAX_Location) obj;
		if (BS_ID == null) {
			if (other.BS_ID != null)
				return false;
		} else if (!BS_ID.equals(other.BS_ID))
			return false;
		if (NAP_ID == null) {
			if (other.NAP_ID != null)
				return false;
		} else if (!NAP_ID.equals(other.NAP_ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WiMAX_Location [BS_ID=" + BS_ID + ", NAP_ID=" + NAP_ID + "]";
	}
	
	
	
	
}
