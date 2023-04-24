package com.example.demo.restful.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime datetime;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime datetime, String message, String details) {
		super();
		this.datetime = datetime;
		this.message = message;
		this.details = details;
	}
	
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionDetails [datetime=" + datetime + ", message=" + message + ", details=" + details + "]";
	}
	
}
