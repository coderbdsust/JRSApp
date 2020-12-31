package com.jrsapp.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class AppStartListener implements ServletContextListener {

	private static Logger log = LoggerFactory.getLogger(AppStartListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.debug("/");
		System.out.println("Application is starting!");
		System.out.println("Application running on port: " + IPLookUp.getPort());
		System.out.println("Application is started!");
		log.debug("Application is started!");
		setLogger("/");

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("Application is stopping!");
		log.debug("Application is stopping!");
	}

	private void setLogger(String file) {
		log.debug("/");

	}

}
