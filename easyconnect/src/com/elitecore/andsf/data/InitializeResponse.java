package com.elitecore.andsf.data;

import com.elitecore.andsf.util.ANDSFConstant;

public class InitializeResponse {
	private String responseCode;
	private String session;
	private TimeOfDay timeout;
	
	public InitializeResponse(){
		this.responseCode = ANDSFConstant.DEFAULT_INITIALIZEREQUESTCODE;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public TimeOfDay getTimeout() {
		return timeout;
	}
	public void setTimeout(TimeOfDay timeout) {
		this.timeout = timeout;
	}
	@Override
	public String toString() {
		return "InitializeResponse [responseCode=" + responseCode
				+ ", session=" + session + ", timeout=" + timeout + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		result = prime * result + ((timeout == null) ? 0 : timeout.hashCode());
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
		InitializeResponse other = (InitializeResponse) obj;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		if (timeout == null) {
			if (other.timeout != null)
				return false;
		} else if (!timeout.equals(other.timeout))
			return false;
		return true;
	}
	
	
}
