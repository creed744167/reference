package com.comsumerbank.java.dto;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;


public interface TransactionResponseProj {
	String getTransactionNumber();
	Double getAmount();
	
	@Value("#{target.account.accountId}")
	Integer getAccountId();
	String getTransactionType();
	LocalDateTime getDate();
	
	
	

}
