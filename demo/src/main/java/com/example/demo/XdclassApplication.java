package com.example.demo;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.MultipartConfigElement;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication 
//一个注解顶下面3个
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
@ServletComponentScan
@MapperScan("com.example.demo.mapper")
//@EnableScheduling //开启定时任务，自动扫描
@EnableAsync //扫描异步方法
@EnableJms //开启支持jms
public class XdclassApplication {
	
	
	
	
	@Bean
	public Topic topic(){
		return new ActiveMQTopic("video.topic");
	}
	
	
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("default.queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(XdclassApplication.class, args);
	}
	
	  @Bean
      public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
          DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
          bean.setPubSubDomain(true);
          bean.setConnectionFactory(activeMQConnectionFactory);
          return bean;
      }
	
	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("10240KB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("1024000KB");  
        return factory.createMultipartConfig();  
    }  
}



/***
 * 修改启动方式为war包启动方式
 * 
 * @return
 */
/*public class XdclassApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XdclassApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(XdclassApplication.class, args);
    }

}*/
