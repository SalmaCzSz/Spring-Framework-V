package com.hello.world.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping("/hello-world")
	public ResponseEntity<String> helloWord(){
		return new ResponseEntity<>("Hello world", HttpStatus.OK);
	}
}
