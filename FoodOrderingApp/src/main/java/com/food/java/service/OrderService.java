package com.food.java.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.food.java.dto.BillRequestDto;
import com.food.java.dto.FoodRequestDto;
import com.food.java.dto.OrderResponseDto;
import com.food.java.dto.OrderResponseProjection;
import com.food.java.entity.OrderDetails;

@Service
public interface OrderService {

	

	String placeOrder(FoodRequestDto foodRequestDto);

	List<OrderResponseProjection> generateBill(BillRequestDto billRequestDto);

	

	

}
