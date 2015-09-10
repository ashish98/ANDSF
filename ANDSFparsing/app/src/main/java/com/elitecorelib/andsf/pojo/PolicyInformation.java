package com.elitecorelib.andsf.pojo;

/**
 * Created by Ashish, Parul and Anurag on 30/6/15.
 */

import android.util.Log;

import com.elitecore.andsfparsing.utility.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Vector;

public class PolicyInformation {

	public String Policy_Latitude;
	public String Policy_Longitude;
	public String Policy_Radius;

	public String UE_Latitude;
	public String UE_Longitude;

	public char unit = 'M';

	public String Policy_EUTRA_CI;
	public String Policy_GERAN_CI;
	public String Policy_LAC;
	public String Policy_PLMN;
	public String Policy_TAC;
	public String Policy_UTRAN_CI;

	public String UE_EUTRA_CI;
	public String UE_GERAN_CI;
	public String UE_LAC;
	public String UE_PLMN;
	public String UE_TAC;
	public String UE_UTRAN_CI;

	public String Policy_BSSID;
	public String Policy_HESSID;
	public String Policy_SSID;

	public String UE_BSSID;
	public String UE_HESSID;
	public String UE_SSID;

	public String Policy_netmask;
	public String Policy_sector_ID;

	public String UE_netmask;
	public String UE_sector_ID;

	public String Policy_NID;
	public String Policy_SID;
	public String Policy_base_ID;

	public String UE_NID;
	public String UE_SID;
	public String UE_base_ID;

	public String dateStart;
	public String dateStop;
	public String timeStart;
	public String timeStop;

	public int accessTechnology;
	public String accessId;
	public int accessNetworkPriority;
	public String secondaryAccessId;

	public static String currentAccessId;
	int geoi = 0;
	
	public static DiscoveryInformation currentDiscoveryInformation;

	public static Vector<Policy> policy = new Vector<Policy>();
	public static Policy validPolicy = null;
	// public static Vector<DiscoveryInformation> discoveryInformation = new
	// Vector<DiscoveryInformation>();

	private static PolicyInformation policyInformationObj = new PolicyInformation();

	private PolicyInformation() {
		// EMPTY CONSTRUCTOR
		// Private so that no other class can access
	}

	public static PolicyInformation getPolicyInformation() {

		if (policyInformationObj == null) {
			policyInformationObj = new PolicyInformation();
		}
		return policyInformationObj;
	}

	public void setPolicy(ArrayList<Policy> policyArrayList) {
		// Log.d("set policy", "success");
		for (int i = 0; i < policyArrayList.size(); i++) {
			policy.addElement(policyArrayList.get(i));
			// Log.d("Policy : " + i + 1, policy.elementAt(i).policyName);
		}
	}

	/*
	 * public void setDiscoveryInformation(ArrayList<DiscoveryInformation>
	 * discoveryInformationArrayList){ for (int i=0;i <
	 * discoveryInformationArrayList.size(); i++){
	 * discoveryInformation.addElement(discoveryInformationArrayList.get(i));
	 * //Log.d("Discovery Information : " + i+1,
	 * discoveryInformation.get(i).toString());
	 * 
	 * } }
	 */

	public void quickSort() {
		quickSort(0, getSizePolicy() - 1);
	}

	public void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = getPolicyObject(lowerIndex + (higherIndex - lowerIndex) / 2).rulePriority;
		while (i <= j) {
			while (getPolicyObject(i).rulePriority < pivot) {
				i++;
			}
			while (getPolicyObject(j).rulePriority > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeElements(policy, i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}

		if (i < higherIndex) {
			quickSort(i, higherIndex);

		}

	}

	private void exchangeElements(Vector<Policy> policy, int i, int j) {
		Collections.swap(policy, i, j);
	}

	public boolean evaluateTimeOfDay(Policy validPolicy) throws ParseException {

		ArrayList<TimeOfDay> timearray = validPolicy.timeOfDay;
		for(int i=0; i< timearray.size(); i++){
			TimeOfDay date = timearray.get(i);
			dateStart = date.dateStart;
			dateStop = date.dateStop;
			timeStart = date.timeStart;
			timeStop = date.timeStop;		
		


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");




		Date dateStart1 = dateFormat.parse(dateStart);
		Date dateStop1 = dateFormat.parse(dateStop);

		Date timeStart1 = timeFormat.parse(timeStart);
		Date timeStop1 = timeFormat.parse(timeStop);

		boolean time;
		Log.d("date start policy", dateStart);
		Log.d("date stop", dateStop);

		time = evaluateTimeOfDay(dateStart1, dateStop1, timeStart1, timeStop1);

		if (time == false) {
			validPolicy = null;
			return false;
		}
		}
		return true;
	}

	public boolean evaluateTimeOfDay(Date DateStart, Date DateStop,
			Date TimeStart, Date TimeStop) throws ParseException {

		// CODE TO GET LOCAL TIME

		/*currentDate1 = local.currentDate;
		
		
		if (currentDate1.after(DateStart) && currentDate1.before(DateStop)) {
			if (currentTime1.after(TimeStart) && currentTime1.before(TimeStop)) {
				return true;
			} else if (currentTime1.equals(TimeStart)) {
				return true;
			} else {
				return false;
			}
		}

		else if (currentDate1.equals(DateStart) || currentDate1.equals(DateStop)) {
			if (currentTime1.after(TimeStart) && currentTime1.before(TimeStop)) {
				return true;
			} else if (currentTime1.equals(TimeStart)) {
				return true;
			} else {
				return false;
			}
		}

		else {
			return false;
		}*/
		return false;
	}

	

	public void evaluateAccessNetworkPriority(Policy validPolicy) {

		
			ArrayList<PrioritizedAccess> PrioritizedAccessArrayList = validPolicy.prioritizedAccess;
			PrioritizedAccess highPriorityObj = PrioritizedAccessArrayList
					.get(0);
			for (int j = 0; j < PrioritizedAccessArrayList.size(); j++) {
				PrioritizedAccess prioritizedAccessObj = PrioritizedAccessArrayList
						.get(j);

				accessTechnology = prioritizedAccessObj.accessTechnology;
				accessId = prioritizedAccessObj.accessId;
				secondaryAccessId = prioritizedAccessObj.secondaryAccessId;
				accessNetworkPriority = prioritizedAccessObj.accessNetworkPriority;
				boolean validityResult = prioritizedAccessObj.validate();
				if (validityResult) {
					int priorityCheck = prioritizedAccessObj
							.compareTo(highPriorityObj);
					if (priorityCheck == 1) {
						highPriorityObj = prioritizedAccessObj;
						connectToNetwork(highPriorityObj);
					}
					
				}
				
			}

	}
	
	public void connectToNetwork(PrioritizedAccess prioritizedAccessObj) {
		currentAccessId=prioritizedAccessObj.accessId;
	}

	public boolean evaluate3GPP() {

		Location3GPP location3GPP = new Location3GPP();
		UE_EUTRA_CI = location3GPP.EUTRA_CI;
		UE_GERAN_CI = location3GPP.GERAN_CI;
		UE_LAC = location3GPP.LAC;
		UE_PLMN = location3GPP.PLMN;
		UE_TAC = location3GPP.TAC;
		UE_UTRAN_CI = location3GPP.UTRAN_CI;

		boolean range = false;

		for (int i = 0; i < policy.size(); i++) {
			ValidityArea validityAreaObj = policy.get(i).validityArea;
			ArrayList<Location3GPP> location3GPPArrayList = validityAreaObj.location_3GPP;
			for (int j = 0; j < location3GPPArrayList.size(); j++) {
				Location3GPP location3GPPObj = location3GPPArrayList.get(j);
				Policy_EUTRA_CI = location3GPPObj.EUTRA_CI;
				Policy_GERAN_CI = location3GPPObj.GERAN_CI;
				Policy_LAC = location3GPPObj.LAC;
				Policy_PLMN = location3GPPObj.PLMN;
				Policy_TAC = location3GPPObj.TAC;
				Policy_UTRAN_CI = location3GPPObj.UTRAN_CI;
				range = evaluate3GPP(Policy_EUTRA_CI, Policy_GERAN_CI,
						Policy_LAC, Policy_PLMN, Policy_TAC, Policy_UTRAN_CI,
						UE_EUTRA_CI, UE_GERAN_CI, UE_LAC, UE_PLMN, UE_TAC,
						UE_UTRAN_CI);
				if (range) {
					return range;
				}
			}
		}
		return range;
	}

	public boolean evaluate3GPP(String Policy_EUTRA_CI, String Policy_GERAN_CI,
			String Policy_LAC, String Policy_PLMN, String Policy_TAC,
			String Policy_UTRAN_CI, String UE_EUTRA_CI, String UE_GERAN_CI,
			String UE_LAC, String UE_PLMN, String UE_TAC, String UE_UTRAN_CI) {

		if (Policy_PLMN.equalsIgnoreCase(UE_PLMN)
				&& (Policy_GERAN_CI.equalsIgnoreCase(UE_GERAN_CI)
						|| Policy_LAC.equalsIgnoreCase(UE_LAC)
						|| Policy_TAC.equalsIgnoreCase(UE_TAC)
						|| Policy_UTRAN_CI.equalsIgnoreCase(UE_UTRAN_CI) || Policy_EUTRA_CI
						.equalsIgnoreCase(UE_EUTRA_CI))) {
			return true;
		}

		return false;
	}

	public boolean evaluate3GPP2() {
		Location3GPP2 location3GPP2 = new Location3GPP2();
		Hrpd hrpd = location3GPP2.hrpd;
		Rat1X rat1X = location3GPP2.rat1x;

		UE_netmask = hrpd.netmask;
		UE_sector_ID = hrpd.sector_ID;
		UE_NID = rat1X.NID;
		UE_SID = rat1X.SID;
		UE_base_ID = rat1X.base_ID;

		boolean range = false;

		for (int i = 0; i < policy.size(); i++) {
			ValidityArea validityArea = policy.get(i).validityArea;
			ArrayList<Location3GPP2> location3GPP2ArrayList = validityArea.location_3GPP2;
			for (int j = 0; j < location3GPP2ArrayList.size(); j++) {

				Location3GPP2 location3GPP2Obj = location3GPP2ArrayList.get(j);
				Hrpd hrpdObj = location3GPP2Obj.hrpd;
				Rat1X rat1X1Obj = location3GPP2Obj.rat1x;
				Policy_netmask = hrpdObj.netmask;
				Policy_sector_ID = hrpdObj.sector_ID;
				Policy_NID = rat1X1Obj.NID;
				Policy_SID = rat1X1Obj.SID;
				Policy_base_ID = rat1X1Obj.base_ID;

				range = evaluate3GPP2(Policy_netmask, Policy_sector_ID,
						Policy_NID, Policy_SID, Policy_base_ID);
				if (range) {
					return range;
				}
			}
		}
		return range;
	}

	public boolean evaluate3GPP2(String Policy_netmask,
			String Policy_sector_ID, String Policy_NID, String Policy_SID,
			String Policy_base_ID) {

		if (Policy_netmask.equals(UE_netmask)
				&& Policy_sector_ID.equals(UE_sector_ID)) {
			return true;
		} else if (Policy_SID.equals(UE_SID)
				&& (Policy_NID.equals(UE_NID) || Policy_base_ID
						.equals(UE_base_ID))) {
			return true;
		}
		return false;
	}

	public boolean evaluateWLAN() {

		WlanLocation wlanLocation = new WlanLocation();
		UE_BSSID = wlanLocation.BSSID;
		UE_SSID = wlanLocation.SSID;
		UE_HESSID = wlanLocation.HESSID;

		if (UE_HESSID == null && UE_BSSID == null && UE_SSID == null) {
			return false;
		}

		boolean range = false;

		for (int i = 0; i < policy.size(); i++) {
			ValidityArea validityArea = policy.get(i).validityArea;
			ArrayList<WlanLocation> wlanLocationArrayList = validityArea.
					WLAN_Location;
			for (int j = 0; j < wlanLocationArrayList.size(); j++) {
				WlanLocation wlanLocationObj = wlanLocationArrayList.get(j);
				Policy_HESSID = wlanLocationObj.HESSID;
				Policy_SSID = wlanLocationObj.SSID;
				Policy_BSSID = wlanLocationObj.BSSID;

				range = evaluateWLAN(Policy_BSSID, Policy_HESSID, Policy_SSID,
						UE_BSSID, UE_HESSID, UE_SSID);
				if (range) {
					return range;
				}
			}
		}
		return range;
	}

	public boolean evaluateWLAN(String Policy_BSSID, String Policy_HESSID,
			String Policy_SSID, String UE_BSSID, String UE_HESSID,
			String UE_SSID) {

		if (Policy_BSSID.equals(UE_BSSID) || Policy_HESSID.equals(UE_HESSID)
				|| Policy_SSID.equals(UE_SSID)) {
			return true;
		}
		return false;
	}

	public boolean isWithinRange(float UE_Latitude, float UE_Longitude,
			float policy_Latitude, float policy_Longitude, float radius,
			char unit) {
		double dist = Utility.getDistanceBetweenLocations(UE_Latitude,
				UE_Longitude, policy_Latitude, policy_Longitude, unit);
		if (dist <= radius) {
			return true;
		} else {
			return false;
		}

	}

	public boolean evaluateGeoLocation() {

		UeLocation ueLocationObj = new UeLocation();
		//Geo_Location geoLocationObj = ueLocationObj.geoLocation;
		//UE_Latitude = geoLocationObj.latitude;
		//UE_Longitude = geoLocationObj.longitude;

		//		if (UE_Latitude == null || UE_Longitude == null) {
		//			return false;
		//		}

		float ue_latitude = Float.parseFloat("23.039568000000003");
		float ue_longitude = Float.parseFloat("72.56600399999999");

		boolean range = false;


		for (int i = geoi; i < policy.size(); i++) {

			ValidityArea validityAreaObj = policy.get(i).validityArea;
			ArrayList<Geo_Location_1> geo_location_1ArrayList = validityAreaObj.
					geo_Location_;
			for (int j = 0; j < geo_location_1ArrayList.size(); j++) {
				Vector<Circular> cirObj = geo_location_1ArrayList.get(j);
				for (int k = 0; k < cirObj.size(); k++) {
					Policy_Latitude = cirObj.get(k).latitude;
					Policy_Longitude = cirObj.get(k).longitude;
					Policy_Radius = cirObj.get(k).radius;
					float policy_latitude = Float.parseFloat(Policy_Latitude);
					float policy_longitude = Float.parseFloat(Policy_Longitude);
					float policy_radius = Float.parseFloat(Policy_Radius);
					range = isWithinRange(ue_latitude, ue_longitude,
							policy_latitude, policy_longitude, policy_radius,
							unit);
					if (range) {
						validPolicy = policy.get(i);
						geoi = i + 1;
						return range;
					}
				}
			}
		}
		return range;
	}

	public int evaluateLocation() {

		// if flag = 0 ---> No location found
		// if flag = 1 ---> geoLocation found
		// if flag = 2 ---> WLAN Location found
		// if flag = 3 ---> 3GPP Location found
		// if flag = 4 ---> 3GPP2 Location found

		int flag = 0;
		boolean geo = evaluateGeoLocation();
		if (geo) {
			flag = 1;
			return flag;
		} else {
			boolean WLAN = evaluateWLAN();
			if (WLAN) {
				flag = 2;
				return flag;
			} else {
				boolean location3GPP = evaluate3GPP();
				if (location3GPP) {
					flag = 3;
					return flag;
				} else {
					boolean location3GPP2 = evaluate3GPP2();
					if (location3GPP2) {
						flag = 4;
						return flag;
					}
				}
			}
		}
		return flag;

	}

	public void evaluate(){
		int location = evaluateLocation(); // to check whether UE in range or
		// not
		boolean time = false;
		if (location == 0) {
			Log.d("STATUS", "NO POLICIES AVAILABLE");
		}

		else {
			/*try {
				time = evaluateTimeOfDay(validPolicy);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			if (time) {
				ArrayList<PrioritizedAccess> temp = validPolicy.prioritizedAccess;
				evaluateAccessNetworkPriority(validPolicy);
			}
			else{
				evaluate();
			}*/
			evaluateAccessNetworkPriority(validPolicy);
		}
	}

	public void evaluatePolicy(ArrayList<Policy> policyArrayList) {

		setPolicy(policyArrayList); // to set the policies
		quickSort(); // to sort the policies on the basis of rule priority
		evaluate();

	}

	// public void getValidPolicy(obj){
	// Log.d("policy INFORMATION", obj.toString())
	// }

	public int getSizePolicy() {
		return policy.size();
	}

	public Policy getPolicyObject(int i) {
		return policy.elementAt(i);
	}

	public void findDiscoveryInformation(PolicyResponse policyResponse) {

		
					List<DiscoveryInformation> discoveryInformationList =policyResponse.discoveryInformation;



		if(discoveryInformationList != null &&
				!discoveryInformationList.isEmpty() && currentAccessId!=null &&
				!"".equals(currentAccessId)){



			for(DiscoveryInformation
					discoveryInformation:discoveryInformationList){


				if(discoveryInformation.accessNetworkInformationWLAN!=null &&
						discoveryInformation.accessNetworkInformationWLAN.SSIDName!=null &&
						discoveryInformation.accessNetworkInformationWLAN.SSIDName.equalsIgnoreCase(currentAccessId)){

					currentDiscoveryInformation = discoveryInformation;

					break;

				}

			}

		}

	}


}
