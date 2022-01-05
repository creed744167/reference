package com.comsumerbank.java.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comsumerbank.java.dto.TransactionRequestDto;
import com.comsumerbank.java.dto.TransactionResponseDto;
import com.comsumerbank.java.entity.Transaction;
import com.comsumerbank.java.repo.AccountRepository;
import com.comsumerbank.java.repo.TransactionRepository;
import com.comsumerbank.java.service.TransactionService;



@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	@Transactional
	public List<TransactionResponseDto> saveTransactions(TransactionRequestDto transactionRequestDto) {
		if (transactionRequestDto.getFromAccountId().equals(transactionRequestDto.getToAccountId()))
			throw new MyCustomizeedException("sender's account and receivers cannot be same");
		Account fromAccount = accountRepository.findById(transactionRequestDto.getFromAccountId()).get();
		Account toAccount = accountRepository.findById(transactionRequestDto.getToAccountId()).get();

		if (fromAccount == null)
			throw new MyCustomizeedException("cannot find sender's account id");
		if (toAccount == null)
			throw new MyCustomizeedException("cannot find receiver's account id");

		Transaction debitTransaction = new Transaction();
		debitTransaction.setAccount(fromAccount);
		debitTransaction.setTransactionType("debit");

		debitTransaction.setDate(LocalDateTime.now());
		BeanUtils.copyProperties(transactionRequestDto, debitTransaction);

		transactionRepository.save(debitTransaction);

		List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<TransactionResponseDto>();

		TransactionResponseDto transactionResponseDto1 = new TransactionResponseDto();
		BeanUtils.copyProperties(debitTransaction, transactionResponseDto1);
		transactionResponseDto1.setAccountId(debitTransaction.getAccount().getAccountId());
		transactionResponseDtoList.add(transactionResponseDto1);

		TransactionResponseDto transactionResponseDto2 = new TransactionResponseDto();
		Transaction creditTransaction = saveCreditTransaction(transactionRequestDto, toAccount);
		BeanUtils.copyProperties(creditTransaction, transactionResponseDto2);
		transactionResponseDto2.setAccountId(creditTransaction.getAccount().getAccountId());
		transactionResponseDtoList.add(transactionResponseDto2);

		return transactionResponseDtoList;
	}

	public Transaction saveCreditTransaction(TransactionRequestDto transactionRequestDto, Account toAccount) {
		Transaction transaction = new Transaction();
		transaction.setAccount(toAccount);
		transaction.setTransactionType("credit");
		BeanUtils.copyProperties(transactionRequestDto, transaction);
		transaction.setDate(LocalDateTime.now());
		
		transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public List<TransactionResponseProj> getTransaction(String transactionNumber) {
		return transactionRepository.findByTransactionNumberLike(transactionNumber);
	}

	@Override
	public List<TransactionResponseProj> getTransactions(Integer accountId) {
		if (accountRepository.findById(accountId) == null)
			throw new MyCustomizeedException("no account exist for the account id: " + accountId);
		List<TransactionResponseProj> transactionResponseProjList = transactionRepository
				.findByAccountAccountId(accountId);
		if (transactionResponseProjList.isEmpty())
			throw new MyCustomizeedException("No transaction for the given account Id" + accountId);
		return transactionResponseProjList;
	}

	@Override
	public List<TransactionResponseProj> getTransactionsByDate(LocalDateTime fromDate, LocalDateTime toDate) {
		if (fromDate.isAfter(toDate))
			throw new MyCustomizeedException("from date and to date are wrong");
		List<TransactionResponseProj> transactionResponseProjList = transactionRepository.findByDateBetween(fromDate,
				toDate);
		if (transactionResponseProjList.isEmpty())
			throw new MyCustomizeedException("No transaction for the given dates");
		return transactionResponseProjList;
	}

}
