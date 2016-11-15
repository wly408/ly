package com.ly.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringApplicationContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContextUtil.applicationContext = applicationContext;

	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}


	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
}
