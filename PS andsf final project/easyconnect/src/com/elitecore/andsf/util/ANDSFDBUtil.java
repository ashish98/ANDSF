package com.elitecore.andsf.util;

public class ANDSFDBUtil {

	public static final String REQUESTINFO_INSERTQUERY = "INSERT INTO TBLMREQUESTINFO(REQID,USERNAME,PASSWORD,IMEI,DEVICETYPE,IMSI,MSISDN,FEATURE,SESSIONID,TIMEOUT,REQTIME) VALUES(SEQ_MREQUESTINFO.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	public static final String REQUESTINFO_GETSESSIONID = "SELECT SEQ_MREQUESTINFO_SESSIONID.nextval FROM DUAL";
}
