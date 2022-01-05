package com.food.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.java.dto.OrderResponseProjection;
import com.food.java.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

	List<OrderResponseProjection> findByOrderNumber(int orderNumber);


	

}
