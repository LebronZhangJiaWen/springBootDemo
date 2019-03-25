package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;

//测试http协议的get请求
@RestController
public class MybatisController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/mybatis/test")
	public Object testPeroperties(){
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("xdclass");
		user.setPhone("10010000");
		int id = userService.add(user);
		
		
		return JsonData.buildSuccess(id);
	}
	
	
	
}
