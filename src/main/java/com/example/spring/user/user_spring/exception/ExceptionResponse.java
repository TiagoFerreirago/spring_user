package com.example.spring.user.user_spring.exception;

import java.time.LocalDate;

public class ExceptionResponse {

	
	private String message;
	private String detail;
	private LocalDate date;
	
	public ExceptionResponse(String message, String detail, LocalDate date) {
		
		this.message = message;
		this.detail = detail;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
