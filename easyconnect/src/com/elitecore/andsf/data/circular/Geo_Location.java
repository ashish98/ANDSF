package com.elitecore.andsf.data.circular;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.elitecore.andsf.data.Circular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ws.andsf.AccessNetworkArea.elitecore.com/" ,name = "Geo_Location")
public class Geo_Location {
	
	private  Circular[] circular;

	public Circular[] getCircular() {
		return circular;
	}

	public void setCircular(Circular[] circular) {
		this.circular = circular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(circular);
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
		Geo_Location other = (Geo_Location) obj;
		if (!Arrays.equals(circular, other.circular))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geo_Location_ [circular=" + Arrays.toString(circular) + "]";
	}

	
	
}
