package com.example.spring.user.userspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class UserSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringApplication.class, args);
	}

	
}
