package com.devs4j.users.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devs4j.users.models.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;

@Service
public class UserServices {
	@Autowired
	private Faker faker;
	
	private List<User> users = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(),
							   faker.name().username(), 
							   faker.dragonBall().character()));
		}
	}
	
	public List<User> getUsers(){
		return users;
	}
}
