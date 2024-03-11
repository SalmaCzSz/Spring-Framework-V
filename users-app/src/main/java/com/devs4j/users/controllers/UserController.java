package com.devs4j.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.entities.User;
import com.devs4j.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, value = "page") int page, @RequestParam(required = false, value = "size") int size){
		return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/usernames")
	public ResponseEntity<Page<String>> getUsernames(@RequestParam(required = false, value = "page") int page, @RequestParam(required = false, value = "size") int size){
		return new ResponseEntity<>(service.getUsernames(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
		return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
	}
}
