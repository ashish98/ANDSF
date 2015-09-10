package com.elitecore.andsf.data;

public class InitializeRequest {

	public String username;
	public String password;
	public String IMEI;
	public String deviceType;
	public String IMSI;
	public String MSISDN;
	public String feature;
	
	
	public InitializeRequest(String username, String password, String iMEI, String deviceType, String iMSI, String mSISDN, String feature) {
		super();
		this.username = username;
		this.password = password;
		IMEI = iMEI;
		this.deviceType = deviceType;
		IMSI = iMSI;
		MSISDN = mSISDN;
		this.feature = feature;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getIMEI() {
		return IMEI;
	}



	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}



	public String getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}



	public String getIMSI() {
		return IMSI;
	}



	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}



	public String getMSISDN() {
		return MSISDN;
	}



	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}



	public String getFeature() {
		return feature;
	}



	public void setFeature(String feature) {
		this.feature = feature;
	}



	public InitializeRequest() {
		
	}



	@Override
	public String toString() {
		return "InitializeRequest [username=" + username + ", password="
				+ password + ", IMEI=" + IMEI + ", deviceType=" + deviceType
				+ ", IMSI=" + IMSI + ", MSISDN=" + MSISDN + ", feature="
				+ feature + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IMEI == null) ? 0 : IMEI.hashCode());
		result = prime * result + ((IMSI == null) ? 0 : IMSI.hashCode());
		result = prime * result + ((MSISDN == null) ? 0 : MSISDN.hashCode());
		result = prime * result
				+ ((deviceType == null) ? 0 : deviceType.hashCode());
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		InitializeRequest other = (InitializeRequest) obj;
		if (IMEI == null) {
			if (other.IMEI != null)
				return false;
		} else if (!IMEI.equals(other.IMEI))
			return false;
		if (IMSI == null) {
			if (other.IMSI != null)
				return false;
		} else if (!IMSI.equals(other.IMSI))
			return false;
		if (MSISDN == null) {
			if (other.MSISDN != null)
				return false;
		} else if (!MSISDN.equals(other.MSISDN))
			return false;
		if (deviceType == null) {
			if (other.deviceType != null)
				return false;
		} else if (!deviceType.equals(other.deviceType))
			return false;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
