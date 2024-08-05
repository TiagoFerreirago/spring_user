package com.example.spring.user.userspring.exception.handler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.spring.user.userspring.exception.ExceptionResponse;

@RestController
@ControllerAdvice
public class CustomizedReponseEntityHandlerException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> genericHandlerException(Exception ex, WebRequest web){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), web.getDescription(false), LocalDate.now());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(HandlerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundHandler(Exception ex, WebRequest web){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(),web.getDescription(false),LocalDate.now());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(HandlerNotFoundUserNullException.class)
	public ResponseEntity<ExceptionResponse> handlelNullUserException(Exception ex, WebRequest web){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), web.getDescription(false), LocalDate.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
