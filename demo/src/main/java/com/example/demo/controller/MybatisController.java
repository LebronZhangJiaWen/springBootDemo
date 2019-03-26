package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

//测试http协议的get请求
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("add")
	public Object testPeroperties(){
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("xdclass");
		user.setPhone("10010000");
		int id = userService.add(user);
		
		
		return JsonData.buildSuccess(id);
	}
	
	/**
	 * 功能描述：查找全部用户
	 * @return
	 */
	@GetMapping("findAll")
	public Object findAll(){
		
       return JsonData.buildSuccess(userMapper.getAll());
	}
	
	
	
	@GetMapping("find_by_id")
	public Object findById(long id){
       return JsonData.buildSuccess(userMapper.findById(id));
	}
	
	
	@GetMapping("del_by_id")
	public Object delById(long id){
	userMapper.delete(id);
       return JsonData.buildSuccess();
	}
	
	@GetMapping("update")
	public Object update(String name,int id){
		User user = new User();
		user.setName(name);
		user.setId(id);
		userMapper.update(user);
	    return JsonData.buildSuccess();
	}
	
	
	@GetMapping("addForTrans")
	@Transactional(propagation=Propagation.REQUIRED)
	public Object addForTrans(){
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("aaa");
		user.setPhone("10010000");
		int id = userService.add(user);
		int i=1/0;
		
		return JsonData.buildSuccess(id);
	}
}
