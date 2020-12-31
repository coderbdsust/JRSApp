package com.jrsapp.init;

import java.lang.management.ManagementFactory;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import javax.naming.InitialContext;

public class IPLookUp {

	public static String getPort() {
		String port = getTomcatPort();
		if (port.equals("0")) {
			return getWeblogicPort();
		}
		return port;
	}

	private static String getTomcatPort() {
		String port = "0";
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			Set<ObjectName> objs = mbs.queryNames(new ObjectName("*:type=Connector,*"),
					Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
			for (ObjectName obj : objs) {
				port = obj.getKeyProperty("port");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return port;
	}

	private static String getWeblogicPort() {
		String port = "0";
		try {
			String serverName = System.getProperty("weblogic.Name");
			InitialContext ctx = new InitialContext();
			MBeanServer server = (MBeanServer) ctx.lookup("java:comp/env/jmx/runtime");
			ObjectName objName = new ObjectName("com.bea:Name=" + serverName + ",Type=Server");
			port = String.valueOf(server.getAttribute(objName, "ListenPort"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return port;
	}
}
