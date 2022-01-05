package com.comsumerbank.java.controller;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comsumerbank.java.dto.CustomerRequestDTO;
import com.comsumerbank.java.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	CustomerRequestDTO customerRequestDTO;
	
	@BeforeEach
	public void setting() {
		customerRequestDTO=new CustomerRequestDTO();
		customerRequestDTO.setCustomerName("Kate");
	    customerRequestDTO.setPhoneNo("744167");
	    customerRequestDTO.setAddress("Egypt");
	}
	
	@Test
	public void saveCustomerDataTest(){
		when(customerService.saveCustomerData(customerRequestDTO)).thenReturn("Data Saved");
		ResponseEntity<String> result= customerController.saveCustomerData(customerRequestDTO);
		assertEquals("Data Saved", result.getBody());
		assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
	}
	

}
