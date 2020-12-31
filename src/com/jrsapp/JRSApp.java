package com.jrsapp;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/*
 * Application starts from here
 */
@ApplicationPath("")
public class JRSApp extends ResourceConfig {

	public JRSApp() {
		packages("com.jrsapp.init");
		packages("com.jrsapp.api");
		//packages("com.jrsapp.dto");
		System.out.println("JRSApp");
	}

}
