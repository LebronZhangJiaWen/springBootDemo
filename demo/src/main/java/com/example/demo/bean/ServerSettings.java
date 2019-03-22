package com.example.demo.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置

@Component
@PropertySource({"classpath:application.properties"})
//@ConfigurationProperties
@ConfigurationProperties(prefix="test")

public class ServerSettings {

	//名称
	
	//@Value("${test.name}")
	private String name;
	
	//@Value("${test.domain}")
	private String domain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	
	
}
