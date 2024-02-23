package com.devs4j.di.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorExample implements BeanPostProcessor{
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LifeCycleBean) {
			log.info("beforeInitialization {}", beanName);
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("afterInitialization {}", beanName);
		return bean;
	}

}
