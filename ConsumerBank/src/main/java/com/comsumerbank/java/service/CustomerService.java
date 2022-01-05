package com.comsumerbank.java.service;

import java.util.List;

import com.comsumerbank.java.dto.CustomerRequestDTO;
import com.comsumerbank.java.dto.CustomerResponse;
import com.comsumerbank.java.dto.CustomerResponseDto;
import com.comsumerbank.java.entity.Customer;

public interface CustomerService {

	String saveCustomerData(CustomerRequestDTO customerRequestDTO);

	List<CustomerResponseDto> getCustomerDetails();

	List<CustomerResponse> getCustomerDetails(String name);
	
	CustomerResponseDto getCustomerDetails (Integer customerId);

}
