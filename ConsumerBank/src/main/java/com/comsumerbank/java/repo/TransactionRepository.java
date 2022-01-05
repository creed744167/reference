package com.comsumerbank.java.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comsumerbank.java.dto.TransactionResponseProj;
import com.comsumerbank.java.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	
	List<TransactionResponseProj> findByTransactionNumberLike(String transactionNumber);
	
	List<TransactionResponseProj> findByAccountAccountId(Integer accountId);
	
	List<TransactionResponseProj> findByDateBetween(LocalDateTime fromDate, LocalDateTime ToDate);

}