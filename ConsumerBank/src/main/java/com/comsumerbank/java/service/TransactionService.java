package com.comsumerbank.java.service;
import java.time.LocalDateTime;
import java.util.List;

import com.comsumerbank.java.dto.TransactionRequestDto;
import com.comsumerbank.java.dto.TransactionResponseDto;
import com.comsumerbank.java.dto.TransactionResponseProj;
import com.comsumerbank.java.service.TransactionService;
public interface TransactionService {
	List<TransactionResponseDto> saveTransactions(TransactionRequestDto transactionRequestDto);

	List<TransactionResponseProj> getTransaction(String transactionNumber);

	List<TransactionResponseProj> getTransactions(Integer accountId);

	List<TransactionResponseProj> getTransactionsByDate(LocalDateTime fromDate, LocalDateTime toDate);

}
