package com.elitecore.andsfparsing.utility;


public class Utility {

	private static final String MODULE = Utility.class.getSimpleName();
	/** Read the object from Base64 string. */

	public static double getDistanceBetweenLocations(double lat1, double lon1, double lat2, double lon2, char unit) {
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

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* :: This function converts radians to decimal degrees : */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
}
