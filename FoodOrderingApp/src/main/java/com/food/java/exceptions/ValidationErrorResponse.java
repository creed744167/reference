package com.food.java.exceptions;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ValidationErrorResponse extends ErrorResponse {
	
	private Map<String, String> errors=new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	

}
