package com.devs4j.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {
	//@Pointcut("execution (* com.devs4j.di.aop.TargetObject.*(..))")
	//@Pointcut("within (com.devs4j.di.aop.*)")
	//@Pointcut("within (com.devs4j.di.aop..*)")
	@Pointcut("@annotation(Devs4jAnnotation)")
	public void targetObjectMethods() {
		
	}
}
