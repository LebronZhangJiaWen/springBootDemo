package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/api/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter.init…………");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter.doFilter…………");
		 HttpServletResponse resp = (HttpServletResponse) response;
		if("admin".equals(request.getParameter("name"))) {
			System.out.println("欢迎"+request.getParameter("name")+"………………登陆！");
			chain.doFilter(request, response);
		}else {
			System.out.println("非法登陆");
			 resp.sendRedirect("/login.html");
			 return;
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("LoginFilter.destroy…………");
		
	}

}
