package com.comsumerbank.java.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comsumerbank.java.dto.CustomerRequestDTO;
import com.comsumerbank.java.dto.CustomerResponseDto;
import com.comsumerbank.java.entity.Customer;
import com.comsumerbank.java.repo.CustomerRepository;
import com.comsumerbank.java.service.CustomerService;

@RestController
@Validated
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<String> saveCustomerData(@RequestBody CustomerRequestDTO customerRequestDTO) {
        
		String response=customerService.saveCustomerData(customerRequestDTO);
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")//get all customers details
	public List<CustomerResponseDto> getCustomerDetails(@NotEmpty(message="Name cannot be empty") @RequestParam String name){
		//if(name!=null) return customerService.getCustomerDetails(name);
		return customerService.getCustomerDetails();
		
	}
	
	@GetMapping("/customers/{customerId}")//get a customer details
	public CustomerResponseDto getCustomerDetails(Integer customerId){
		return customerService.getCustomerDetails(customerId);
		
	}

	
}
