package com.devs4j.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.devs4j.users.entities.User;
import com.devs4j.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
@ComponentScan(basePackages = {"com.devs4j.users"})
@EnableJpaRepositories("com.devs4j.users.repositories")
public class UsersAppApplication implements ApplicationRunner{
	
	private Faker faker = new Faker();
	
	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i = 0; i < 200000; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			
			repository.save(user);
		}
	}

}
