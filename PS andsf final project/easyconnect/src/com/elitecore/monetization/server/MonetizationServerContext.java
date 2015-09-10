package com.elitecore.monetization.server;

import com.elitecore.core.serverx.ServerContext;

public interface MonetizationServerContext extends ServerContext{

	public long getServerUpTime();
	
//	public DBCDRDriver getDBCDRDriver(long dbCDRDriverId);
	
}
