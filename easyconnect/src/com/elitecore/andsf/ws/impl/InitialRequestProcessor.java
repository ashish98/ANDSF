package com.elitecore.andsf.ws.impl;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.elitecore.andsf.data.InitializeRequest;
import com.elitecore.andsf.data.InitializeResponse;
import com.elitecore.andsf.data.TimeOfDay;
import com.elitecore.andsf.util.ANDSFConstant;
import com.elitecore.andsf.util.ANDSFDBUtil;
import com.elitecore.core.util.db.DBUtility;
import com.elitecore.monetization.db.commons.JNDIDSManager;

public class InitialRequestProcessor {
	
	private String MODULE = "[InitialRequestProcessor]";
	protected static final int QUERY_TIMEOUT_ERROR_CODE = 01013;

	public InitializeResponse processInitialRequest(InitializeRequest initializeRequest){
		InitializeResponse initializeResponse = new InitializeResponse();
		TimeOfDay timeOfDay = new TimeOfDay(); 
		
		if(initializeRequest != null){
			Connection connection = null;
			PreparedStatement pstmtSessionid = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				connection = JNDIDSManager.getConnection();
				pstmtSessionid = connection.prepareStatement(ANDSFDBUtil.REQUESTINFO_GETSESSIONID);
				 rs = pstmtSessionid.executeQuery();
				int sessionId = 0;
				if(rs.next()){
					sessionId = rs.getInt(1);
				}
				
				pstmt = connection.prepareStatement(ANDSFDBUtil.REQUESTINFO_INSERTQUERY);
				pstmt.setString(1, initializeRequest.getUsername());
				pstmt.setString(2, initializeRequest.getPassword());
				pstmt.setString(3, initializeRequest.getIMEI());
				pstmt.setString(4, initializeRequest.getDeviceType());
				pstmt.setString(5, initializeRequest.getIMSI());
				pstmt.setString(6, initializeRequest.getMSISDN());
				pstmt.setString(7, initializeRequest.getFeature());
				pstmt.setString(8, String.valueOf(sessionId));
				System.out.println(MODULE + " sessionId : " + sessionId);
				initializeResponse.setSession(String.valueOf(sessionId));
				
//				Timestamp currentTimeStamp = DBUtil.getCurrentTimeStamp();
				Calendar cal = Calendar.getInstance();
				pstmt.setTimestamp(10, new Timestamp(cal.getTimeInMillis()));
				SimpleDateFormat dateStartSDF = new SimpleDateFormat(ANDSFConstant.INITIALIZEREQUEST_DATESTARTFORMAT);
				String startDate = dateStartSDF.format(cal.getTime());
				System.out.println(MODULE + " StartDate : " + startDate);
				SimpleDateFormat timeStartSDF = new SimpleDateFormat(ANDSFConstant.INITIALIZEREQUEST_TIMESTARTFORMAT);
				String startTime = timeStartSDF.format(cal.getTime());
				System.out.println(MODULE + " StartTime : " + startTime);
				cal.add(Calendar.MINUTE, ANDSFConstant.timeoutInMinute);
				String stopDate = dateStartSDF.format(cal.getTime());
				System.out.println(MODULE + " stopDate : " + stopDate);
				String stopTime = timeStartSDF.format(cal.getTime());
				System.out.println(MODULE + " stopTime : " + stopTime);
				timeOfDay.setDateStart(startDate);
				timeOfDay.setDateStop(stopDate);
				timeOfDay.setTimeStart(startTime);
				timeOfDay.setTimeStop(stopTime);
				initializeResponse.setTimeout(timeOfDay);
//				cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + ANDSFConstant.timeoutInMinute);
				pstmt.setTimestamp(9, new Timestamp(cal.getTimeInMillis()));
				
				
				pstmt.executeUpdate();
				connection.commit();
								
				//Now Pushing this into OPENX server for Policy Update
				String url = "http://192.168.0.196:9090/plugins/userService/userservice?type=add&secret=secretkey&username={IMEI}&password={IMEI}&name={IMEI}&email=test@test.com";
				url = url.replace("{IMEI}", initializeRequest.getIMEI());
				
				System.out.println(MODULE+"  User add string is: "+url);
				URL obj = new URL(url);
			//	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 
				// optional default is GET
			//	con.setRequestMethod("GET");
		 
				//add request header
			//	con.setRequestProperty("User-Agent", "Mozilla/5.0");
		 
			//	int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " );
				
				
				} catch (SQLException se){
					if(se.getErrorCode() == QUERY_TIMEOUT_ERROR_CODE){
						System.out.println(MODULE + " DB Query Timeout while initial request process. Reason : " + se.getMessage());
//						EasyConnectServer.getInstance().getServerContext().generateSystemAlert(Alerts.DB_QUERY_TIMEOUT.getSeverity(), Alerts.DB_QUERY_TIMEOUT, MODULE, "DB Query Timeout when location subscriber");
					}
					se.printStackTrace();
					System.out.println(MODULE + " exception : " + se.getMessage());
					System.out.println(MODULE + " exception : " + se.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(MODULE + " exception : " + e.getMessage() );
					System.out.println(MODULE + " exception : " + e.getMessage());
				}finally{
					DBUtility.closeQuietly(pstmtSessionid);
					DBUtility.closeQuietly(pstmt);
					DBUtility.closeQuietly(rs);
					DBUtility.closeQuietly(connection);
					
				}
		}else{
			System.out.println(MODULE + " intializeRequest is null");
		}
		System.out.println(MODULE + " returning initializeResponse : " + initializeResponse);
		return initializeResponse;
	}
	
}
