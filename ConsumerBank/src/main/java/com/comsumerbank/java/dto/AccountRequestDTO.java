package com.comsumerbank.java.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountRequestDTO {
	
	@NotNull(message = "account no cannot be empty")
	private Long accountNumber;
	@NotNull(message = "balance no cannot be empty")
	@Min(value = 1000,message="amount cannt be less than 1000")
	private double balance;
	private Integer customerId;
	@NotEmpty(message="Account type cannot be empty")
	private String accountType;
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
