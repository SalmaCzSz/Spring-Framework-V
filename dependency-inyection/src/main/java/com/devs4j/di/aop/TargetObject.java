package com.devs4j.di.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.devs4j.di.lifecycle.LifeCycleBean;

@Component
public class TargetObject {
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
	
	public void hello(String message) {
		log.info(message);
	}
	
	public void foo() {
		log.info("Foo");
	}
}
