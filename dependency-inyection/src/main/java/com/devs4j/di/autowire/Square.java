package com.devs4j.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figura {
	@Value("2.5")
	private double side;
	
	@Override
	public double calculateArea() {
		return side * side;
	}

}