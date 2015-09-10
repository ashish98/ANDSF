==============EasyConnect====================
EasyConnect is SM for EasyConnect Android Application

==============INSTALLATION============   

- Copy the EasyConnect-x.x.x.x.tar.gz to setups directory.

- Untar the gz file. This will create a directory named EasyConnect-Vx.x.x.x inside setups directory.     

 In Unix, gunzip EasyConnect-x.x.x.x.tar.gz      

 tar -xvf EasyConnect-Vx.x.x.x.tar

- Create a home directory for EasyConnect.	

e.g. /opt/Setup/EasyConnect- Go to EasyConnect-Vx.x.x.x directory and run the installation script as below:	

	sh install.sh /opt/Setup/EasyConnect		     


- Now you need to create an EasyConnect User in the Oracle database and setup the database for Server Manager. You will find the 

following files in the “$EasyConnect_HOME/setup/database/fullsetup” directory.

• EasyConnect-schema.sql

• EasyConnect.sql

- Copy the above SQL script files available in “setup/database/fullsetup” folder to your Oracle OS user.

For Example:

	scp EasyConnect-schema.sql oracle@192.168.8.94:/home/oracle/EasyConnect

- The EasyConnect-schema.sql file comprises sql statements, which you may alter values (that are represented within <>), as per your 

needs. This query is used to create EasyConnect user in the database.

- On your database server, connect to sqlplus as “sys” user and execute the EasyConnect-schema.sql query as follows:

	sqlplus <sys-username>/<sys-password> as sysdba

	SQL>@EasyConnect-schema.sql

- Once the above-mentioned file is executed, a user is created. In this document, we assume that no updates are made in the 

EasyConnect-schema.sql file. Thus on execution of this file, a user named EasyConnect is created.

- Copy the “EasyConnect.sql” file to your Oracle OS user.

For Example:

	scp EasyConnect.sql oracle@192.168.8.94:/home/oracle/EasyConnect

- Connect to the Oracle server for executing the EasyConnect.sql file.

For Example:

	sqlplus EasyConnect/EasyConnect

- Now go to the directory where you've copied the EasyConnect.sql on the Oracle database server. On your database server, connect 

to sqlplus (from the same directory) as EasyConnect user and then execute the EasyConnect.sql query as follows:

	sqlplus EasyConnect/EasyConnect@EasyConnect

where,
   EasyConnect/EasyConnect@EasyConnect represents username/password@ORACLE_SID
  
    SQL>@EasyConnect.sql


- Once done log out of the Oracle database.

- Log on to the system as the OS user you’ve created for installation of the EasyConnect.

- Open file /home/EasyConnect/WEB-INF/database.properties and update Database configuration details for:	

	hibernate.connection.datasource = jdbc/EasyConnectdb
	hibernate.show_sql=true
	hibernate.format_sql=true


- Now do the web-hosting of the “EasyConnect” directory in the $TOMCAT_HOME/conf/server.xml file as shown below:

	<Context path="" docBase="<EasyConnect_HOME>"

	debug="0" reloadable="true" crossContext="true" />

- This completes the process of installing the EasyConnect.


==============Server Manager GUI============================

- Install TOMCAT 6.0.XX in the Home directory of the user.

- Edit the jakarta-tomcat-6.0.XX/conf/server.xml file and make the following   host entry:		

Example of a host entry made for the Server Manager:		
	<Host name="EasyConnect.com" debug="0" appBase="<EasyConnect_HOME>"		               
	 unpackWARs="false" autoDeploy="true">		      
	<Logger className="org.apache.catalina.logger.FileLogger"		                
	prefix="server-manager_log." suffix=".txt" timestamp="true"/>		     
	<Context path="" docBase="<EasyConnect_HOME>" debug="0" reloadable="true" crossContext="true" />		
	</Host> 

- Access server through following URL:   
  
URL : http://elitesm.com (If required, make host entry)

 - Login through super user 'Admin'			
	User Name : admin			
	Password  : admin  	. 	
