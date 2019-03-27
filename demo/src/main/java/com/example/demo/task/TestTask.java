package com.example.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 
 * @author zhangjiawen
 *
 * 2019年3月27日
 */
@Component
public class TestTask {
	
	@Scheduled(fixedRate=3000)//每2秒执行一次
	/****
	 * cron 定时任务表达式 @Scheduled(cron="* * * * * *") 表示每秒
	 *    1）crontab 工具  https://tool.lu/crontab/
        2、fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；）
        3、fixedDelay: 上一次执行结束时间点后xx秒再次执行
        4、fixedDelayString:  字符串形式，可以通过配置文件指定
	 */
	public void firstTask() {
		System.out.println("定时任务demo:"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()) );
		
	}

}
