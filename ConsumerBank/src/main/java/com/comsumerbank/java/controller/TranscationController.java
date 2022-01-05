package com.comsumerbank.java.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comsumerbank.java.dto.TransactionRequestDto;
import com.comsumerbank.java.dto.TransactionResponseDto;
import com.comsumerbank.java.dto.TransactionResponseProj;
import com.comsumerbank.java.service.TransactionService;

@RestController
public class TranscationController {
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transactions")
	public ResponseEntity<List<TransactionResponseDto>> saveTransactions(@Valid @RequestBody TransactionRequestDto transactionRequestDto){
		return new ResponseEntity<List<TransactionResponseDto>>(transactionService.saveTransactions(transactionRequestDto),HttpStatus.ACCEPTED);
	}
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionResponseProj>> getTransaction(@RequestParam String transactionNumber){
		return new ResponseEntity<List<TransactionResponseProj>>(transactionService.getTransaction(transactionNumber),HttpStatus.ACCEPTED);
	}
	@GetMapping("/transactions/{accountId}")
	public ResponseEntity<List<TransactionResponseProj>> getTransactions(@PathVariable Integer accountId){
		return new ResponseEntity<List<TransactionResponseProj>>(transactionService.getTransactions(accountId),HttpStatus.ACCEPTED);
	}
	@GetMapping("/transactions/date")
	public ResponseEntity<List<TransactionResponseProj>> getTransactionsByDate(@RequestParam("fromDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate, @RequestParam("toDate") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate){
		return new ResponseEntity<List<TransactionResponseProj>>(transactionService.getTransactionsByDate(fromDate,toDate), HttpStatus.ACCEPTED);
	}
}
