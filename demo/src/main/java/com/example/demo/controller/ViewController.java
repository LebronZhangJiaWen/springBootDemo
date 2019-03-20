package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//测试http协议的get请求
@Controller
public class ViewController {

	
	
	@RequestMapping("/test/home")
	public Object testHome(){
		return "index";	
	}
	
}
