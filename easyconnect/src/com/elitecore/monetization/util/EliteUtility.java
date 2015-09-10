package com.elitecore.monetization.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EliteUtility {
	private static final String MODULE = "[EliteUtility]";
	private static String smAbsolutePath;

	public static String getSMHome() {
		return "MS";
	}

	public static final void setSMHome(String smAbsolutePath) {
		EliteUtility.smAbsolutePath = smAbsolutePath;
	}

	public static double getLocationDistance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'M') {
			dist = (dist * 1.609344) * 1000;
		}
		return (dist);
	}
	/* :: This function converts decimal degrees to radians : */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* :: This function converts radians to decimal degrees : */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	


	
	public static Timestamp getFormatedDate(Timestamp timestamp,String dateFormat){
		Timestamp ts = null;
		try {
			if(timestamp == null || dateFormat == null || "".equals(dateFormat)){
				return null;
			}
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			String date = format.format(timestamp.getTime());
			Date d = format.parse(date);
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			String format2 = formatter.format(d);
			ts = new Timestamp(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
		
	}
	
	
	public static String getStringDate(Timestamp timestamp,String dateFormat){
		String date = null;
		try {
			if(timestamp == null || dateFormat == null || "".equals(dateFormat)){
				return null;
			}
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			date = format.format(timestamp.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		
	}
	
	
}
