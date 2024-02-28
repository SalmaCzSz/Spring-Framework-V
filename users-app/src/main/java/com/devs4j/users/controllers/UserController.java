package com.devs4j.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devs4j.users.models.*;
import com.devs4j.users.services.*;

@RestController
@RequestMapping("/users") // definición del recurso
public class UserController {
	@Autowired
	private UserServices userService;
	
	@GetMapping // handler methods, se ejecutan a traves de un método HTTP y un recurso
	public ResponseEntity<List<User>> get(){
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String userName){
		return new ResponseEntity<User>(userService.getUserByUsername(userName), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String userName, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, userName), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String userName){
		userService.deleteUser(userName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
