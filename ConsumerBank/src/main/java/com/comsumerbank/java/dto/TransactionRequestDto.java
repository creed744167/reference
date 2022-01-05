package com.comsumerbank.java.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class TransactionRequestDto {
	
	@NotNull(message="sender's account id cannot be null")
	private Integer fromAccountId;
	@NotNull(message="reciever's account id cannot be null")
	private Integer toAccountId;
	
	@NotNull(message="amount cannot be null")
	@Min(value=10,message="you cannot send less than 10 rs")
	private Double amount;
	
	public Integer getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@NotEmpty
	private String transactionNumber;

}
