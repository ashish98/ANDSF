package com.elitecore.andsf.data;

public class PrioritizedAccess {
	private String accessId;
    private int accessNetworkPriority;
    private int accessTechnology;
    private String secondaryAccessId;
	public String getAccessId() {
		return accessId;
	}
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}
	public int getAccessNetworkPriority() {
		return accessNetworkPriority;
	}
	public void setAccessNetworkPriority(int accessNetworkPriority) {
		this.accessNetworkPriority = accessNetworkPriority;
	}
	public int getAccessTechnology() {
		return accessTechnology;
	}
	public void setAccessTechnology(int accessTechnology) {
		this.accessTechnology = accessTechnology;
	}
	public String getSecondaryAccessId() {
		return secondaryAccessId;
	}
	public void setSecondaryAccessId(String secondaryAccessId) {
		this.secondaryAccessId = secondaryAccessId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessId == null) ? 0 : accessId.hashCode());
		result = prime * result + accessNetworkPriority;
		result = prime * result + accessTechnology;
		result = prime
				* result
				+ ((secondaryAccessId == null) ? 0 : secondaryAccessId
						.hashCode());
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
		PrioritizedAccess other = (PrioritizedAccess) obj;
		if (accessId == null) {
			if (other.accessId != null)
				return false;
		} else if (!accessId.equals(other.accessId))
			return false;
		if (accessNetworkPriority != other.accessNetworkPriority)
			return false;
		if (accessTechnology != other.accessTechnology)
			return false;
		if (secondaryAccessId == null) {
			if (other.secondaryAccessId != null)
				return false;
		} else if (!secondaryAccessId.equals(other.secondaryAccessId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrioritizedAccess [accessId=" + accessId
				+ ", accessNetworkPriority=" + accessNetworkPriority
				+ ", accessTechnology=" + accessTechnology
				+ ", secondaryAccessId=" + secondaryAccessId + "]";
	}    
    
    
    
}
