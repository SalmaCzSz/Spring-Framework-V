package com.devs4j.di.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Scope("prototype")
@Lazy // si el bean es Lazy no se inicializa a menos que sea inyectado
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean{
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/**
	 * Se ejecuta durante la construcción del bean 
	 **/
	@Override
	public void setBeanName(String name) {
		log.info("Bean name aware {}", name);
	}
	
	/**
	 * Se ejecuta después de la inyección de dependencias 
	 **/
	@PostConstruct
	public void init() {
		log.info("PostConstruct");
	}
	
	/**
	 * Se ejecuta antes que el bean sea destruido
	 * No se ejecuta para beans prototype 
	 * Solo se ejecutan durante una terminación de la JVM de forma normal
	 **/
	@PreDestroy
	public void destroyBean() {
		log.info("PreDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("afterPropertiesSet method");
	}
	
	public void destroy() throws Exception {
		log.info("destroy method");
	}
}
