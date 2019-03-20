package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class TestServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("========ContextListenerInitialized=========");
		System.out.println("资源预加载……");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("========ContextListenerDestroyed=========");
		
	}
	
}
