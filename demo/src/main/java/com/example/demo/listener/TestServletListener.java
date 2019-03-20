package com.example.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class TestServletListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("=====RequestListenerDestroyed=====");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("=====RequestListenerInitialized=====");
		
	}

}
