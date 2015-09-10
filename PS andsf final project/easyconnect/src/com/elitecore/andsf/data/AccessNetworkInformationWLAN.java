package com.elitecore.andsf.data;

public class AccessNetworkInformationWLAN {

	private String bssid;
    private String hssid;
	private String SSIDName; 
	private boolean ssidHidden;
    private boolean autoJoin;
    
    /**
     * Possible Values
     * wep,wpa/wpa2,wep enterprise,wpa enterprise
     */
    private String securityType;
    private boolean useWPAPSK;
    
    /**
     * For TTLS only,Mention {IMSI} if you want to replace at client side with client attributes
     */
    private String userName;
    
    /**
     * Used for WPA2 and TTLS
     */
    private String password;
    private boolean isHexPassworde;
    
    /**
     * TLS
		LEAP
		PEAP
		TTLS
		EAPSIM
		EAPFAST
     */
    private String EAPTypeAuths;
    
    
    /**
     * For TTLS only
     * PAP
		CHAP
		MSCHAP
		MSCHAPV2
     */
    private String authProtocols;
    

    
    //Wi-Fi setting Name for display into GUI
    private String nodeName;
    
    //Minimumm signal level if we want to define
    private int signalLevel;
    
   /**
    * Wifi Settings Name 
    */
    private String networkMode;
	
    /**
     * to display itinto MAPS
     */
	private String geoRadius;    
    private String latitude;
    private String longtitude;
    private boolean policyHotspot;
    
	public String getBssid() {
		return bssid;
	}
	public void setBssid(String bssid) {
		this.bssid = bssid;
	}
	public String getHssid() {
		return hssid;
	}
	public void setHssid(String hssid) {
		this.hssid = hssid;
	}
	public String getSSIDName() {
		return SSIDName;
	}
	public void setSSIDName(String sSIDName) {
		SSIDName = sSIDName;
	}
	public boolean isSsidHidden() {
		return ssidHidden;
	}
	public void setSsidHidden(boolean ssidHidden) {
		this.ssidHidden = ssidHidden;
	}
	public boolean isAutoJoin() {
		return autoJoin;
	}
	public void setAutoJoin(boolean autoJoin) {
		this.autoJoin = autoJoin;
	}
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public boolean isUseWPAPSK() {
		return useWPAPSK;
	}
	public void setUseWPAPSK(boolean useWPAPSK) {
		this.useWPAPSK = useWPAPSK;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isHexPassworde() {
		return isHexPassworde;
	}
	public void setHexPassworde(boolean isHexPassworde) {
		this.isHexPassworde = isHexPassworde;
	}
	public String getEAPTypeAuths() {
		return EAPTypeAuths;
	}
	public void setEAPTypeAuths(String eAPTypeAuths) {
		EAPTypeAuths = eAPTypeAuths;
	}
	public String getAuthProtocols() {
		return authProtocols;
	}
	public void setAuthProtocols(String authProtocols) {
		this.authProtocols = authProtocols;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getSignalLevel() {
		return signalLevel;
	}
	public void setSignalLevel(int signalLevel) {
		this.signalLevel = signalLevel;
	}
	public String getNetworkMode() {
		return networkMode;
	}
	public void setNetworkMode(String networkMode) {
		this.networkMode = networkMode;
	}
	public String getGeoRadius() {
		return geoRadius;
	}
	public void setGeoRadius(String geoRadius) {
		this.geoRadius = geoRadius;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	/**
	 * @return the policyHotspot
	 */
	public boolean isPolicyHotspot() {
		return policyHotspot;
	}
	/**
	 * @param policyHotspot the policyHotspot to set
	 */
	public void setPolicyHotspot(boolean policyHotspot) {
		this.policyHotspot = policyHotspot;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((EAPTypeAuths == null) ? 0 : EAPTypeAuths.hashCode());
		result = prime * result
				+ ((SSIDName == null) ? 0 : SSIDName.hashCode());
		result = prime * result
				+ ((authProtocols == null) ? 0 : authProtocols.hashCode());
		result = prime * result + (autoJoin ? 1231 : 1237);
		result = prime * result + ((bssid == null) ? 0 : bssid.hashCode());
		result = prime * result
				+ ((geoRadius == null) ? 0 : geoRadius.hashCode());
		result = prime * result + ((hssid == null) ? 0 : hssid.hashCode());
		result = prime * result + (isHexPassworde ? 1231 : 1237);
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longtitude == null) ? 0 : longtitude.hashCode());
		result = prime * result
				+ ((networkMode == null) ? 0 : networkMode.hashCode());
		result = prime * result
				+ ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + (policyHotspot ? 1231 : 1237);
		result = prime * result
				+ ((securityType == null) ? 0 : securityType.hashCode());
		result = prime * result + signalLevel;
		result = prime * result + (ssidHidden ? 1231 : 1237);
		result = prime * result + (useWPAPSK ? 1231 : 1237);
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		AccessNetworkInformationWLAN other = (AccessNetworkInformationWLAN) obj;
		if (EAPTypeAuths == null) {
			if (other.EAPTypeAuths != null)
				return false;
		} else if (!EAPTypeAuths.equals(other.EAPTypeAuths))
			return false;
		if (SSIDName == null) {
			if (other.SSIDName != null)
				return false;
		} else if (!SSIDName.equals(other.SSIDName))
			return false;
		if (authProtocols == null) {
			if (other.authProtocols != null)
				return false;
		} else if (!authProtocols.equals(other.authProtocols))
			return false;
		if (autoJoin != other.autoJoin)
			return false;
		if (bssid == null) {
			if (other.bssid != null)
				return false;
		} else if (!bssid.equals(other.bssid))
			return false;
		if (geoRadius == null) {
			if (other.geoRadius != null)
				return false;
		} else if (!geoRadius.equals(other.geoRadius))
			return false;
		if (hssid == null) {
			if (other.hssid != null)
				return false;
		} else if (!hssid.equals(other.hssid))
			return false;
		if (isHexPassworde != other.isHexPassworde)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longtitude == null) {
			if (other.longtitude != null)
				return false;
		} else if (!longtitude.equals(other.longtitude))
			return false;
		if (networkMode == null) {
			if (other.networkMode != null)
				return false;
		} else if (!networkMode.equals(other.networkMode))
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (policyHotspot != other.policyHotspot)
			return false;
		if (securityType == null) {
			if (other.securityType != null)
				return false;
		} else if (!securityType.equals(other.securityType))
			return false;
		if (signalLevel != other.signalLevel)
			return false;
		if (ssidHidden != other.ssidHidden)
			return false;
		if (useWPAPSK != other.useWPAPSK)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AccessNetworkInformationWLAN [bssid=" + bssid + "\n hssid="
				+ hssid + "\n SSIDName=" + SSIDName + "\n ssidHidden="
				+ ssidHidden + "\n autoJoin=" + autoJoin + "\n securityType="
				+ securityType + "\n useWPAPSK=" + useWPAPSK + "\n userName="
				+ userName + "\n password=" + password + "\n isHexPassworde="
				+ isHexPassworde + "\n EAPTypeAuths=" + EAPTypeAuths
				+ "\n authProtocols=" + authProtocols + "\n nodeName=" + nodeName
				+ "\n signalLevel=" + signalLevel + "\n networkMode="
				+ networkMode + "\n geoRadius=" + geoRadius + "\n latitude="
				+ latitude + "\n longtitude=" + longtitude + "\n policyHotspot="
				+ policyHotspot + "]";
	}	

    
    
   
    
    
    
}
