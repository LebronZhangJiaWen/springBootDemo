package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ServerSettings;
import com.example.demo.exception.MyException;

//测试http协议的get请求
@RestController
public class ExceptionController {

	
	private Map<String,Object> params = new HashMap<>();
	
	
	
	@RequestMapping("/exception")
	public Object testPeroperties(){
		Map map=new HashMap();
		map.put("msg", "哈喽啊！");
		int i=1/0;
		return map;	
	}
	
	@RequestMapping("/myException")
	public Object myException(){
		throw new MyException("499", "哎呀！错了");
	}
	
	
	
}
