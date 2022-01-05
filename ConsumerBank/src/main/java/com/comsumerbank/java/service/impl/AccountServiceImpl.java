package com.comsumerbank.java.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.comsumerbank.java.dto.AccountRequestDTO;
import com.comsumerbank.java.dto.AccountResponse;
import com.comsumerbank.java.dto.AccountResponseDto;
import com.comsumerbank.java.entity.Account;
import com.comsumerbank.java.entity.Customer;
import com.comsumerbank.java.exception.CustomerNotFoundException;
import com.comsumerbank.java.repo.AccountRepository;
import com.comsumerbank.java.repo.CustomerRepository;
import com.comsumerbank.java.service.AccountService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public AccountResponseDto saveAccountData(AccountRequestDTO accountRequestDto) {
		java.util.Optional<Customer> optionalCustomer = customerRepository.findById(accountRequestDto.getCustomerId());

		if (optionalCustomer.isEmpty())
			throw new CustomerNotFoundException(
					"Customer doesnt exixt for the ID " + accountRequestDto.getCustomerId());
		Account account = new Account();
		BeanUtils.copyProperties(accountRequestDto, account);
		account = accountRepository.save(account);
		AccountResponseDto responseDto = new AccountResponseDto();
		BeanUtils.copyProperties(account, responseDto);
		return responseDto;
	}

	/*
	 * @Override public List<AccountResponseDto> getAllCustomers() { // TODO
	 * Auto-generated method stub return accountRepository.findAccounts(); }
	 * 
	 * @Override public AccountResponse findAccountByAccountNumber(@PathVariable
	 * long accountNumber) { // TODO Auto-generated method stub return
	 * accountRepository.findByAccountNumber(accountNumber); }
	 */

}
