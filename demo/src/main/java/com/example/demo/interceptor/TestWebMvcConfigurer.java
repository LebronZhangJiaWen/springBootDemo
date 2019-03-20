package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class TestWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TestIntercepter()).addPathPatterns("/aop/*/**").excludePathPatterns("/aop/haha/**");
		registry.addInterceptor(new TestIntercepter2()).addPathPatterns("/aop/*/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
