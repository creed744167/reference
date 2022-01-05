package com.comsumerbank.java.exception;

public class CustomerNotFoundException extends RuntimeException{

	public  CustomerNotFoundException(String message) {
		super(message);
	}
}
