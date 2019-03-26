package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.util.JsonData;
import com.example.demo.util.JsonUtils;
import com.example.demo.util.RedisClient;

//测试http协议的get请求
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate template;
	
	@Autowired
	private RedisClient redisClient;
	
	
	
	@GetMapping("add")
	private Object addRedis(String str){
		 template.opsForValue().set("demo", str);
		return JsonData.buildSuccess(str);
	}
	
	@GetMapping("get")
	private Object getRedis(){
		String string = template.opsForValue().get("demo");
		return JsonData.buildSuccess(string);
	}
	
	
	@GetMapping(value="save_user")
	public Object saveUser(){
		User user = new User(1, "abc", "11", 0, new Date());
		String userStr = JsonUtils.obj2String(user);
		boolean flag = redisClient.set("base:user:11", userStr);
		return JsonData.buildSuccess(flag);
		
	}
	
	@GetMapping(value="find_user")
	public Object findUser(){

		String userStr = redisClient.get("base:user:11");
		User user = JsonUtils.string2Obj(userStr, User.class);
		
		return JsonData.buildSuccess(user);
		
	}
	
}
