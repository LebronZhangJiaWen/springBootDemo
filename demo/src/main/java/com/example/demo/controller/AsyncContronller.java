package com.example.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.async.TestAsync;
import com.example.demo.util.JsonData;

@RestController
@RequestMapping("/async")
public class AsyncContronller {
	
	@Autowired
	private TestAsync  testAsync;
	
	@GetMapping("test")
	public Object testAsync() throws InterruptedException, ExecutionException {
		long start=System.currentTimeMillis();
		//testAsync.async1();
		//testAsync.async2();
		
		Future<String> async3 = testAsync.async3();
		Future<String> async4 = testAsync.async4();
		for(;;) {
			if(async3.isDone() && async4.isDone()) {
				
				System.out.println(async3.get());
				System.out.println(async4.get());
				break;
			}
			
		}
		
		long end =System.currentTimeMillis();
		System.out.println("主线程耗时："+(end-start));
		
		return JsonData.buildSuccess(end-start);
	}
	
}
