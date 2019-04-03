package com.example.demo.jms.activemq.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DefaultConsumer {

	
	@JmsListener(destination="default.queue")
	public void receiveQueue(String text){
		System.out.println("DefaultConsumer收到的报文为:"+text);
	}
	
	
	
}
