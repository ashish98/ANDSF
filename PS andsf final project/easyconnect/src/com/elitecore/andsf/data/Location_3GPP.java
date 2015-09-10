package com.elitecore.andsf.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location_3GPP {

	@XmlElement
	public String EUTRA_CI;
	@XmlElement
	public String GERAN_CI;
	@XmlElement
	public String LAC;
	@XmlElement
	public String PLMN;
	@XmlElement
	public String TAC;
	@XmlElement
	public String UTRAN_CI;
	
	public String getEUTRA_CI() {
		return EUTRA_CI;
	}
	public void setEUTRA_CI(String eUTRA_CI) {
		EUTRA_CI = eUTRA_CI;
	}
	public String getGERAN_CI() {
		return GERAN_CI;
	}
	public void setGERAN_CI(String gERAN_CI) {
		GERAN_CI = gERAN_CI;
	}
	public String getLAC() {
		return LAC;
	}
	public void setLAC(String lAC) {
		LAC = lAC;
	}
	public String getPLMN() {
		return PLMN;
	}
	public void setPLMN(String pLMN) {
		PLMN = pLMN;
	}
	public String getTAC() {
		return TAC;
	}
	public void setTAC(String tAC) {
		TAC = tAC;
	}
	public String getUTRAN_CI() {
		return UTRAN_CI;
	}
	public void setUTRAN_CI(String uTRAN_CI) {
		UTRAN_CI = uTRAN_CI;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((EUTRA_CI == null) ? 0 : EUTRA_CI.hashCode());
		result = prime * result
				+ ((GERAN_CI == null) ? 0 : GERAN_CI.hashCode());
		result = prime * result + ((LAC == null) ? 0 : LAC.hashCode());
		result = prime * result + ((PLMN == null) ? 0 : PLMN.hashCode());
		result = prime * result + ((TAC == null) ? 0 : TAC.hashCode());
		result = prime * result
				+ ((UTRAN_CI == null) ? 0 : UTRAN_CI.hashCode());
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
		Location_3GPP other = (Location_3GPP) obj;
		if (EUTRA_CI == null) {
			if (other.EUTRA_CI != null)
				return false;
		} else if (!EUTRA_CI.equals(other.EUTRA_CI))
			return false;
		if (GERAN_CI == null) {
			if (other.GERAN_CI != null)
				return false;
		} else if (!GERAN_CI.equals(other.GERAN_CI))
			return false;
		if (LAC == null) {
			if (other.LAC != null)
				return false;
		} else if (!LAC.equals(other.LAC))
			return false;
		if (PLMN == null) {
			if (other.PLMN != null)
				return false;
		} else if (!PLMN.equals(other.PLMN))
			return false;
		if (TAC == null) {
			if (other.TAC != null)
				return false;
		} else if (!TAC.equals(other.TAC))
			return false;
		if (UTRAN_CI == null) {
			if (other.UTRAN_CI != null)
				return false;
		} else if (!UTRAN_CI.equals(other.UTRAN_CI))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location_3GPP [EUTRA_CI=" + EUTRA_CI + ", GERAN_CI=" + GERAN_CI
				+ ", LAC=" + LAC + ", PLMN=" + PLMN + ", TAC=" + TAC
				+ ", UTRAN_CI=" + UTRAN_CI + "]";
	}
	
	
	
	
}
