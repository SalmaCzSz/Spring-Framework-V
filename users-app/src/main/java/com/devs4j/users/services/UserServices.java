package com.devs4j.users.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	public User getUserByUsername(String userName) {
		return users.stream().filter(u -> u.getUserName()
										   .equals(userName))
										   .findAny()
										   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", userName)));
	}
}
