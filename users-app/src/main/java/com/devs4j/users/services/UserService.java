package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.User;
import com.devs4j.users.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Page<String> getUsernames(int page, int size){
		return userRepository.findUsernames(PageRequest.of(page, size));
	}
	
	public Page<User> getUsers(int page, int size){
		return userRepository.findAll(PageRequest.of(page, size));
	}
	
	public User getUserById(Long userId) {
		return userRepository.findById(userId)
							 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId)));
	}
}
