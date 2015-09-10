package com.elitecore.andsf.data;

import java.util.Arrays;

public class Policy {
	
	 private String PLMN;
     private int enable;
     private int policyId;
     private String policyName;
     private PrioritizedAccess[] prioritizedAccess;
     private boolean roaming;
     private int rulePriority;
     private TimeOfDay[] timeOfDay;
     private int updatePolicy;
     private ValidityArea validityArea;
     private String version;
	public String getPLMN() {
		return PLMN;
	}
	public void setPLMN(String pLMN) {
		PLMN = pLMN;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public PrioritizedAccess[] getPrioritizedAccess() {
		return prioritizedAccess;
	}
	public void setPrioritizedAccess(PrioritizedAccess[] prioritizedAccess) {
		this.prioritizedAccess = prioritizedAccess;
	}
	public boolean isRoaming() {
		return roaming;
	}
	public void setRoaming(boolean roaming) {
		this.roaming = roaming;
	}
	public int getRulePriority() {
		return rulePriority;
	}
	public void setRulePriority(int rulePriority) {
		this.rulePriority = rulePriority;
	}
	public TimeOfDay[] getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(TimeOfDay[] timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public int getUpdatePolicy() {
		return updatePolicy;
	}
	public void setUpdatePolicy(int updatePolicy) {
		this.updatePolicy = updatePolicy;
	}
	public ValidityArea getValidityArea() {
		return validityArea;
	}
	public void setValidityArea(ValidityArea validityArea) {
		this.validityArea = validityArea;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PLMN == null) ? 0 : PLMN.hashCode());
		result = prime * result + enable;
		result = prime * result + policyId;
		result = prime * result
				+ ((policyName == null) ? 0 : policyName.hashCode());
		result = prime * result + Arrays.hashCode(prioritizedAccess);
		result = prime * result + (roaming ? 1231 : 1237);
		result = prime * result + rulePriority;
		result = prime * result + Arrays.hashCode(timeOfDay);
		result = prime * result + updatePolicy;
		result = prime * result
				+ ((validityArea == null) ? 0 : validityArea.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Policy other = (Policy) obj;
		if (PLMN == null) {
			if (other.PLMN != null)
				return false;
		} else if (!PLMN.equals(other.PLMN))
			return false;
		if (enable != other.enable)
			return false;
		if (policyId != other.policyId)
			return false;
		if (policyName == null) {
			if (other.policyName != null)
				return false;
		} else if (!policyName.equals(other.policyName))
			return false;
		if (!Arrays.equals(prioritizedAccess, other.prioritizedAccess))
			return false;
		if (roaming != other.roaming)
			return false;
		if (rulePriority != other.rulePriority)
			return false;
		if (!Arrays.equals(timeOfDay, other.timeOfDay))
			return false;
		if (updatePolicy != other.updatePolicy)
			return false;
		if (validityArea == null) {
			if (other.validityArea != null)
				return false;
		} else if (!validityArea.equals(other.validityArea))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Policy [PLMN=" + PLMN + ", enable=" + enable + ", policyId="
				+ policyId + ", policyName=" + policyName
				+ ", prioritizedAccess=" + Arrays.toString(prioritizedAccess)
				+ ", roaming=" + roaming + ", rulePriority=" + rulePriority
				+ ", timeOfDay=" + Arrays.toString(timeOfDay)
				+ ", updatePolicy=" + updatePolicy + ", validityArea="
				+ validityArea + ", version=" + version + "]";
	}
     
     
     
	
     
}


