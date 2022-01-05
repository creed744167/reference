package com.comsumerbank.java.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comsumerbank.java.dto.AccountResponse;
import com.comsumerbank.java.dto.AccountResponseDto;
import com.comsumerbank.java.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	
	  @Query(
	  value="select new com.consumerbank.java.dto.AccountResponseDto(a.accountId,a.accountNumber) form Account a"
	  ) List<AccountResponseDto> findAccounts();
	  
	  AccountResponse findByAccountNumber(Long accountNumber);
	 
}
