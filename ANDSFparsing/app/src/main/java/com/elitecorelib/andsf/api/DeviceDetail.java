package com.elitecorelib.andsf.api;

import java.util.Date;

import com.elitecorelib.andsf.pojo.Geo_Location;
import com.elitecorelib.andsf.pojo.Location3GPP;
import com.elitecorelib.andsf.pojo.Location3GPP2;
import com.elitecorelib.andsf.pojo.WiMAXLocation;
import com.elitecorelib.andsf.pojo.WlanLocation;


/**
 * This class will contain Information about current device status.
 * It will hold mainly below parameters for devices.
 * @author brijesh.mistry
 *
 */
public class DeviceDetail {

	private Geo_Location ueGeo_Location;
	
	private Location3GPP ue3GPPLocation;
	
	private Location3GPP2 ue3GPP2Location;
	
	private WiMAXLocation ueWiMaxocation;
	
	private WlanLocation ueWlanLocation;
	
	private Date lastupdated;
	
	private String IMSI;
	
	private String IMEI;
	
	private String MSISDN;
	
	private static DeviceDetail deviceLocation ;
	
	

	void setInstance(Geo_Location ueGeo_Location,
			Location3GPP ue3gppLocation, Location3GPP2 ue3gpp2Location,
			WiMAXLocation ueWiMaxocation, WlanLocation ueWlanLocation,
			Date lastupdated,String IMSI,String IMEI,String MSISDN){
		deviceLocation = new DeviceDetail(ueGeo_Location, ue3gppLocation, ue3gpp2Location, ueWiMaxocation, ueWlanLocation, lastupdated,IMSI,IMEI,MSISDN);
	}
	
	private DeviceDetail(Geo_Location ueGeo_Location,
			Location3GPP ue3gppLocation, Location3GPP2 ue3gpp2Location,
			WiMAXLocation ueWiMaxocation, WlanLocation ueWlanLocation,
			Date lastupdated,String IMSI,String IMEI,String MSISDN) {
		super();
		this.ueGeo_Location = ueGeo_Location;
		ue3GPPLocation = ue3gppLocation;
		ue3GPP2Location = ue3gpp2Location;
		this.ueWiMaxocation = ueWiMaxocation;
		this.ueWlanLocation = ueWlanLocation;
		this.lastupdated = lastupdated;
		this.IMEI = IMEI;
		this.IMSI = IMSI;
		this.MSISDN = MSISDN;
		
	}
	
	
	public static DeviceDetail getInstance(){
		return deviceLocation;
	}

	public Geo_Location getUeGeo_Location() {
		return ueGeo_Location;
	}

	public Location3GPP getUe3GPPLocation() {
		return ue3GPPLocation;
	}

	public Location3GPP2 getUe3GPP2Location() {
		return ue3GPP2Location;
	}

	public WiMAXLocation getUeWiMaxocation() {
		return ueWiMaxocation;
	}

	public WlanLocation getUeWlanLocation() {
		return ueWlanLocation;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public String getIMSI() {
		return IMSI;
	}

	public String getIMEI() {
		return IMEI;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	
	
	
	
}
