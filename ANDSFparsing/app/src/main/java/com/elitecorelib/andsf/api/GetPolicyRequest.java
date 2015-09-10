package com.elitecorelib.andsf.api;

import com.elitecorelib.andsf.pojo.UeLocation;

public class GetPolicyRequest{
		//		/final String session,final String tag,final UeLocation ue_Location,final String HexToken,final String tz 
		private String session;
		private String tag;
		private UeLocation ue_Location;
		private  String HexToken;
		private String tz;

		public String getSession() {
			return session;
		}
		public void setSession(String session) {
			this.session = session;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public UeLocation getUe_Location() {
			return ue_Location;
		}
		public void setUe_Location(UeLocation ue_Location) {
			this.ue_Location = ue_Location;
		}
		public String getHexToken() {
			return HexToken;
		}
		public void setHexToken(String hexToken) {
			HexToken = hexToken;
		}
		public String getTz() {
			return tz;
		}
		public void setTz(String tz) {
			this.tz = tz;
		}


	}