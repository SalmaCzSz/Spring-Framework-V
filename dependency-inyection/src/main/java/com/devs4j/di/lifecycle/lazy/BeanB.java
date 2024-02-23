package com.devs4j.di.lifecycle.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.devs4j.di.lifecycle.LifeCycleBean;
import jakarta.annotation.PostConstruct;

@Component
@Lazy(false)
public class BeanB {
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
	
	@Autowired
	private BeanA bean;
	
	@PostConstruct
	public void init() {
		log.info("Init BeanB");
	}
}
