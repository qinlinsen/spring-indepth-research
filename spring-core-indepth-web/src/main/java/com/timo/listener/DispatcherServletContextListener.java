package com.timo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author qinlinsen
 * @since 2018-09-24
 */
public class DispatcherServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context destroyed ");
	}
}
