package com.comsumerbank.java.controller;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comsumerbank.java.dto.AccountRequestDTO;
import com.comsumerbank.java.dto.AccountResponse;
import com.comsumerbank.java.dto.AccountResponseDto;
import com.comsumerbank.java.exception.ErrorResponse;
import com.comsumerbank.java.exception.ValidationErrorResponse;
import com.comsumerbank.java.service.AccountService;

@RestController
@Validated
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/accounts")
	public ResponseEntity<String> saveAccount(@Valid @RequestBody AccountRequestDTO accountRequestDto){
		accountService.saveAccountData(accountRequestDto);
		return new ResponseEntity<String>("account added succesfully",HttpStatus.ACCEPTED);
	}
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountResponseDto>> getAccounts(){
		return new ResponseEntity<List<AccountResponseDto>>(accountService.getAccounts(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/accounts/{customerId}")
	public ResponseEntity<List<AccountResponseProj>> getAccountsByCustomer(@NotNull(message="customer id cannot be null") @PathVariable Integer customerId){
		return new ResponseEntity<List<AccountResponseProj>>(accountService.getAccountsByCustomer(customerId),HttpStatus.ACCEPTED);
	}
}
