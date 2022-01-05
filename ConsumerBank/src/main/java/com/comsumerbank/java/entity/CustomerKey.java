package com.comsumerbank.java.entity;

import java.io.Serializable;

public class CustomerKey implements Serializable{

	private  String phoneNo;
	private String emailId;
	
	

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
