package com.rec.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AppContextListener implements ServletContextListener {
		private Logger logger = Logger.getLogger(AppContextListener.class);
	 public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		 logger.info("Context object destroyed");
		
	}
	 
	 public void contextInitialized(ServletContextEvent contextEvent) {
			// TODO Auto-generated method stub
		 logger.info("**********Context initialization started**********");
		 ServletContext context = contextEvent.getServletContext();
		 String log4jConfigLocation = context.getInitParameter("Log4j-config-location");
		 String fullpath = context.getRealPath(""+File.separator+log4jConfigLocation);
		 PropertyConfigurator.configure(fullpath);
		 logger.info("*********Log4j initialized successfully");
		 logger.info("*********context initialization Ended*********");
		}
	}


