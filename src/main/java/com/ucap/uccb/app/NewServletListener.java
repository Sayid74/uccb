/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucap.uccb.app;

import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Sayid
 */
public class NewServletListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext c = sce.getServletContext();
		String r = c.getRealPath("/WEB-INF");
		if (r != null)
		{
			File f = new File(r);
			String p = f.getAbsolutePath();
			System.setProperty("org.owasp.esapi.resources", p+"/esapi");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.clearProperty("org.owasp.esapi.resoures");
	}
}
