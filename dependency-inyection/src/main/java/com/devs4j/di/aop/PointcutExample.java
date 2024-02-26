package com.devs4j.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {
	@Pointcut("execution (* com.devs4j.di.aop.TargetObject.*(..))")
	public void targetObjectMethods() {
		
	}
}
