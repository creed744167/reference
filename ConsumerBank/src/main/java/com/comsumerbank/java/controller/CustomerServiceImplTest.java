package com.comsumerbank.java.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.comsumerbank.java.dto.CustomerRequestDTO;
import com.comsumerbank.java.entity.Customer;
import com.comsumerbank.java.repo.CustomerRepository;
import com.comsumerbank.java.service.CustomerService;
import com.comsumerbank.java.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	CustomerRequestDTO customerRequestDTO;

	Customer customer;

	@BeforeEach
	public void setting() {
		customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setCustomerName("Kate");
		customerRequestDTO.setPhoneNo("744167");
		customerRequestDTO.setAddress("Egypt");

	}

	@Test
	public void saveCustomerDataTest() {
		when(customerRepository.save(any(Customer.class))).thenAnswer(i -> {
			Customer customer = i.getArgument(0);
			customer.setCustomerId(1);
			return customer;
		});

		String result = customerServiceImpl.saveCustomerData(customerRequestDTO);
		assertEquals("Data Saved", result);
		verify(customerRepository).save(any(Customer.class));

	}
};
