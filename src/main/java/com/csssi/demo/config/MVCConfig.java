package com.csssi.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.csssi.demo.interceptor.LoginInterceptor;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("loginInterceptor")
	private HandlerInterceptor loginInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).excludePathPatterns(LoginInterceptor.IGNORE_PATH).addPathPatterns("/*");
	}

}
