package com.elitecore.monetization.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

	private static final String MODULE = "[CXT-LSTNR]";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(MODULE+" Monetization Server is stopped.");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
//			EliteUtility.setSMHome(arg0.getServletContext().getRealPath(""));
			EasyConnectServer.getInstance().startServer();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
