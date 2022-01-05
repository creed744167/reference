package com.comsumerbank.java.repo;
import com.comsumerbank.java.dto.CustomerResponse;
import com.comsumerbank.java.dto.CustomerResponseDto;
import com.comsumerbank.java.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

List<CustomerResponseDto> findByCustomerName(String name);

//List<Customer> findByCustomerNameContaining(String name);
List<CustomerResponse> findByCustomerNameContaining(String name);

//@Query(value="select c from Customer c where c.phoneNo=:phoneNo and c.address=:address", nativeQuery = true )
//Customer findCustomerData(String phoneNo,String address);

}
