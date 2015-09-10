package com.elitecorelib.andsf.api;
public class InitializeRequest{
		//final String userName,final String password,final String IMEI,final String deviceType,final String IMSI,final String MSISDN,final String feature 
		private String userName;
		private String password;
		private String IMEI;
		private String deviceType;
		private String IMSI;
		private String MSISDN;
		private String feature;

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

	}