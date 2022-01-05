package com.food.java.exceptions;

import java.time.LocalDateTime;

import lombok.Data;


public class ErrorResponse {
	
	private String message;
	private Integer responseCode;
	private LocalDateTime time;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	

}
