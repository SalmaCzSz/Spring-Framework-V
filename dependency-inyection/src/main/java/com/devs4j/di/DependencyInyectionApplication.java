package com.devs4j.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.di.atributo.*;
import com.devs4j.di.profiles.*;
import com.devs4j.di.qualifiers.*;
import com.devs4j.di.scopes.EjemploScope;

@SpringBootApplication
public class DependencyInyectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependencyInyectionApplication.class);
	
	public static void main(String[] args) {
		// crear "Coche" con Dependency Inyection
		/*ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);*/
		
		// crear "Coche" sin Dependency Inyection
		// se utiliza el constructor para crear el objeto
		/*
	 	Motor motor = new Motor("Xl1", 1981);
		Coche coche = new Coche("VW", 1986, motor);
		System.out.println(coche);
		*/
		
		
		
		/*final Logger log = LoggerFactory.getLogger(DependencyInyectionApplication.class);
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		Perro perro = context.getBean(Perro.class);
		log.info("Objeto perro {}", perro.getNombre());	
		
		Pajaro pajaro = context.getBean(Pajaro.class);
		log.info("Objeto pajaro {}", pajaro.getNombre());
		
		Avion avion = context.getBean(Avion.class);
		avion.volar();*/
		
		/*Animal animal = context.getBean("pajaro", Animal.class);
		log.info("Animal nombre = {} edad = {}", animal.getNombre(), animal.getEdad());*/
		
		/*Nido nido = context.getBean(Nido.class);
		nido.imprimir();*/
		
		
		
		/*ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		EnvironmentService environmentService =  context.getBean(EnvironmentService.class);
		log.info("Active environment {}", environmentService.getEnvironment()); */
		
		
		
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		EjemploScope ejemploScopeI = context.getBean(EjemploScope.class);
		EjemploScope ejemploScopeII = context.getBean(EjemploScope.class);
		log.info("Are beans equal {}", ejemploScopeI.equals(ejemploScopeII));
		log.info("Are beans == {}", ejemploScopeI == ejemploScopeII);
	}
}
