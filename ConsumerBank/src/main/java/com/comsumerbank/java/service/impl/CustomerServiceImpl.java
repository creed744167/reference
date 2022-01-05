package com.comsumerbank.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comsumerbank.java.dto.CustomerRequestDTO;
import com.comsumerbank.java.dto.CustomerResponse;
import com.comsumerbank.java.dto.CustomerResponseDto;
import com.comsumerbank.java.entity.Customer;
import com.comsumerbank.java.repo.CustomerRepository;
import com.comsumerbank.java.service.CustomerService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String saveCustomerData(CustomerRequestDTO customerRequestDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDTO, customer);
		Customer savedCustomer=customerRepository.save(customer);
		if(savedCustomer!=null) return "Data Saved";
			return "Data Not Saved";
		
	}

	@Override
	public List<CustomerResponseDto> getCustomerDetails() {
		List<CustomerResponseDto> customerResponseList = new ArrayList();
		Iterator it = customerRepository.findAll().iterator();

		while (it.hasNext()) {

			CustomerResponseDto responseDto = new CustomerResponseDto();
			BeanUtils.copyProperties(it.next(), responseDto);

			customerResponseList.add(responseDto);
		}
		return customerResponseList;

	}

	@Override
	public List<CustomerResponse> getCustomerDetails(String name) {
		/*
		 * List<CustomerResponseDto> customerResponseList =new ArrayList<>();
		 * List<Customer> customerList =
		 * customerRepository.findByCustomerNameContaining(name);
		 * 
		 * for (Customer customer : customerList) { CustomerResponseDto responseDto =new
		 * CustomerResponseDto(); BeanUtils.copyProperties(customer, responseDto);
		 * customerResponseList.add(responseDto);
		 * 
		 * } return customerResponseList;
		 */
		return customerRepository.findByCustomerNameContaining(name);
	}

	@Override
	public CustomerResponseDto getCustomerDetails(Integer customerId) {
		// Also handling null exception
		Customer customer = new Customer();
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		
		if (optionalCustomer.isPresent())
			customer = optionalCustomer.get();
		
		BeanUtils.copyProperties(customerResponseDto, customerResponseDto);
		return customerResponseDto;
	}

}
