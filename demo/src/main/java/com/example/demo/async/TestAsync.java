package com.example.demo.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/***
 * 异步方法类
 * @author zhangjiawen
 *
 * 2019年3月27日
 */

@Component
@Async
public class TestAsync {
	
	public void async1() throws InterruptedException {
		long start=System.currentTimeMillis();
		Thread.sleep(2000);
		long end=System.currentTimeMillis();
		System.out.println("async1:"+(end-start));
	}

	public void async2() throws InterruptedException {
		long start=System.currentTimeMillis();
		Thread.sleep(5000);
		long end=System.currentTimeMillis();
		System.out.println("async2:"+(end-start));
	}
	
	
	public Future<String> async3() throws InterruptedException {
		long start=System.currentTimeMillis();
		Thread.sleep(2000);
		long end=System.currentTimeMillis();
		System.out.println("async3:"+(end-start));
		return new AsyncResult<String>("任务3");
	}
	
	public Future<String> async4() throws InterruptedException {
		long start=System.currentTimeMillis();
		Thread.sleep(5000);
		long end=System.currentTimeMillis();
		System.out.println("async4:"+(end-start));
		return new AsyncResult<String>("任务4");
	}
	
}
