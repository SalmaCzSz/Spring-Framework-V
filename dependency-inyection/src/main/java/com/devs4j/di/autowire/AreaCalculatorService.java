package com.devs4j.di.autowire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaCalculatorService {
	@Autowired
	private List<Figura> figures;
	
	public double calcAreas() {
		double area = 0;
		
		for(Figura figure : figures) {
			area += figure.calculateArea();
		}
		
		return area;
	}
}
