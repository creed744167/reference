package com.comsumerbank.java.service;

import java.util.List;

import com.comsumerbank.java.dto.AccountRequestDTO;
import com.comsumerbank.java.dto.AccountResponse;
import com.comsumerbank.java.dto.AccountResponseDto;

public interface AccountService {

	AccountResponseDto saveAccountData(AccountRequestDTO accountRequestDto);
	
	List<AccountResponseDto> getAccounts();

	List<AccountResponseProj> getAccountsByCustomer(Integer customerId);

}
