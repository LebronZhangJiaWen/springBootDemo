package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.ServerSettings;

//测试http协议的get请求
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	
	@Autowired
	private ServerSettings serverSettings;
	
	@RequestMapping("/test")
	public Object testHome(ModelMap modelMap){
		modelMap.put("serverSettings", serverSettings);
		return "/thymeleaf/demo/index";	
	}
	
}
