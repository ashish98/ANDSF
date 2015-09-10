package com.elitecore.monetization.server;

import com.elitecore.monetization.util.EliteUtility;

public class EasyConnectServer {
	private static final String MODULE = "[EC-SVR]";
	private static EasyConnectServer easyConnectServer;
	protected static final String DEVELOPMENT_VERSION_NO = "Development Version";

	private EasyConnectServer() {

	}

	public static EasyConnectServer getInstance() {
		if (easyConnectServer == null) {
			synchronized (EasyConnectServer.class) {
				if (easyConnectServer == null) {
					String serverHome = EliteUtility.getSMHome();
					try {
						easyConnectServer = new EasyConnectServer();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return easyConnectServer;
	}


	public void startServer() {
		new Thread() {
			@Override
			public void run() {
				Thread.currentThread().setName("SRV-STARTUP");
				System.out.println("Starting EasyConnectServer");
//				CacheLoader cacheLoader = new CacheLoader(serverContext);
//				cacheLoader.cacheAllData();
			}
		}.start();





	/**
	 * Server level scheduled task for performing server internal tasks. Current
	 * implementation validates server license at regular interval and if 
	 * license is found invalid, it stops all the active services.
	 * 
	 * @author Eltiecore Technologies Ltd.
	 *
	 */
	
	/**
	 * Server level scheduled task for deleting old ios profile file.
	 * 
	 * @author Eltiecore Technologies Ltd.
	 *
	 */
	}
}
