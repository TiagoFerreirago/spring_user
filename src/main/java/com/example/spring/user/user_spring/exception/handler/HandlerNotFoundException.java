package com.example.spring.user.user_spring.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HandlerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HandlerNotFoundException(String msg) {
		super(msg);
	}

}
