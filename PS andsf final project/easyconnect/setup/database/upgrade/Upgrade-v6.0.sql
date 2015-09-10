--=============================================By Siddharth Saraf===============================
--=============================================Changes on 05/05/2014============================	
	ALTER TABLE TBLMVOUCHERCONFIG MODIFY (VOUCHERBATCHNAME VARCHAR2(255));
	ALTER TABLE TBLMDEAL ADD CURRENCY VARCHAR2(20);
	
Insert into TBLMDEALTAG (TAGID,TAGNAME,IMGPATH,STATUS,DESCRIPTION,CREATEDATE,CREATEDBYSTAFFID,LASTMODIFIEDDATE,LASTMODIFIEDBYSTAFFID) 
values (1,'Featured','1430978439608.jpg','Y','Special Deal with high discount is treated as Featured deal',CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1);
	
--==============================================================================================
--=============================================Changes on 25/05/2014============================
CREATE SEQUENCE  SEQ_MVERSION MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 20 CACHE 20 NOORDER  NOCYCLE ;
--==============================================================================================
--=============================================Changes on 26/05/2014============================
ALTER TABLE TBLMSERVERCONFIG ADD WIFICONNECTIONTIMEOUT NUMERIC(8) default 20;
ALTER TABLE TBLMSERVERCONFIG ADD WIFISETTING VARCHAR2(20);
--==============================================================================================
--=============================================Changes on 30/05/2014============================
ALTER TABLE TBLMSERVERCONFIG ADD WINDOWSPACKAGENAME VARCHAR2(56);
ALTER TABLE TBLMSERVERCONFIG ADD WINDOWSSHAREDSECRETKEY VARCHAR2(256);
UPDATE TBLMSERVERCONFIG SET WINDOWSPACKAGENAME= 'com.elitecore.eliteconnect' WHERE SERVERCONFIGID=1;
UPDATE TBLMSERVERCONFIG SET WINDOWSSHAREDSECRETKEY= 'dadomeoicdaodmd.oectlztiatt' WHERE SERVERCONFIGID=1;
ALTER TABLE TBLMSERVERCONFIG MODIFY (ROLLINGTYPE VARCHAR2(10 BYTE));
ALTER TABLE TBLMSERVERCONFIG ADD (ROLLINGUNITTYPE VARCHAR2(50));
--==============================================================================================
--=============================================Changes on 11/06/2014============================
ALTER TABLE TBLMSERVERCONFIG ADD (WINCLIENTSECRET VARCHAR2(100));
ALTER TABLE TBLMSERVERCONFIG ADD (WINSID VARCHAR2(1000));
--=============================================By Siddharth Saraf End=================================================





--======================================  By Sagar Vaghela ==================================

--============================= 09-06-2015========================================

ALTER TABLE TBLMSUBSCRIBERPROFILE MODIFY (IMEI VARCHAR2(128) NOT NULL);

--============================ Changes On 10-06-2015 =======================
create table TBLVOUCHERCDR(
imsi varchar(25),
imei varchar(25),
msisdn varchar (25),
createdate timestamp

)

--============================ Changes On 12-06-2015 =======================


CREATE TABLE TBLMCDRDRIVERINSTANCE(
	CDRDRIVERINSTANCEID		NUMERIC(20),
	NAME					VARCHAR(255)	NOT NULL,
	DESCRIPTION			VARCHAR(255),
   	CREATEDBYSTAFFID       	NUMERIC(20),
   	LASTMODIFIEDBYSTAFFID    NUMERIC(20),
  	LASTMODIFIEDDATE       	TIMESTAMP,
   	CREATEDATE             	TIMESTAMP,
	MVNO					NUMERIC(20)	DEFAULT 1,
	RULESET					VARCHAR(512),
	DRIVERINSTANCEID		NUMERIC(20),
	CONSTRAINT PK_MCDRDRIVERINSTANCE PRIMARY KEY (CDRDRIVERINSTANCEID),
	CONSTRAINT FK_MCDRDRIVERINSTANCE FOREIGN KEY(MVNO) REFERENCES TBLMGROUP(GROUPID)
);


CREATE SEQUENCE SEQ_MCDRDRIVERINSTANCE
      INCREMENT BY 1
      START WITH 101
      MAXVALUE 999999
      MINVALUE 1
      CACHE 20;

	  
CREATE TABLE TBLMDBCDRFIELDMAPPING(
  	FIELDMAPPINGID			NUMERIC(20),
  	LOGICALNAME			VARCHAR(50),
  	DBFIELD				VARCHAR(50),
  	DATATYPE				NUMERIC(8),
  	DEFAULTVALUE			VARCHAR(50),
  	CDRDRIVERINSTANCEID     	NUMERIC(20),
  	CONSTRAINT PK_MDBCDRFIELDMAPPING PRIMARY KEY (FIELDMAPPINGID),
	CONSTRAINT FK1_MDBCDRFIELDMAPPING FOREIGN KEY (CDRDRIVERINSTANCEID) REFERENCES TBLMCDRDRIVERINSTANCE (CDRDRIVERINSTANCEID)
);

CREATE SEQUENCE SEQ_MDBCDRFIELDMAPPING
      INCREMENT BY 1
      START WITH 101
      MAXVALUE 999999
      MINVALUE 1
      CACHE 20;      

	  
CREATE TABLE TBLMDBCDRDRIVER(
	DATABASEDS            	VARCHAR(50),
	ISBATCHUPDATE			VARCHAR(8),
	BATCHSIZE				NUMERIC(8),
	BATCHUPDATEINTERVAL		NUMERIC(16),
	BATCHQUERYTIMEOUT		NUMERIC(16),
	TABLENAME				VARCHAR(50),
	CREATEDATEFIELDNAME		VARCHAR(50),
	CDRDRIVERINSTANCEID		NUMERIC(20),
	CONSTRAINT FK1_MDBCDRDRIVER  FOREIGN KEY (CDRDRIVERINSTANCEID) REFERENCES TBLMCDRDRIVERINSTANCE (CDRDRIVERINSTANCEID)
);

CREATE SEQUENCE SEQ_MDBCDRDRIVER
      INCREMENT BY 1
      START WITH 101
      MAXVALUE 999999
      MINVALUE 1
      CACHE 20;
--======================================  By Sagar Vaghela End ==================================