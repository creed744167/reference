package com.food.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.java.dto.BillRequestDto;
import com.food.java.dto.FoodRequestDto;
import com.food.java.dto.FoodResponseProjection;
import com.food.java.dto.OrderResponseDto;
import com.food.java.dto.OrderResponseProjection;
import com.food.java.entity.FoodItems;
import com.food.java.entity.OrderDetails;
import com.food.java.service.FoodService;
import com.food.java.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	FoodService foodService;

	@Autowired
	OrderService orderService;

	@GetMapping("/menue/searchtype")
	public ResponseEntity<List<FoodResponseProjection>> searchFoodByType(@RequestBody FoodItems foodItems) {
		return new ResponseEntity<List<FoodResponseProjection>>(foodService.searchFoodByType(foodItems),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/menue")
	public ResponseEntity<List<FoodItems>> getFoodItems() {

		return new ResponseEntity<List<FoodItems>>(foodService.getFoodItems(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/menue/search")
	public ResponseEntity<List<FoodResponseProjection>> searchFood(@RequestBody FoodItems foodItems) {

		return new ResponseEntity<List<FoodResponseProjection>>(foodService.searchFood(foodItems), HttpStatus.ACCEPTED);
	}

	@PostMapping("/menue/makeorder")
	public ResponseEntity<String> placeOrder(@RequestBody FoodRequestDto foodRequestDto) {
		return new ResponseEntity<String>(orderService.placeOrder(foodRequestDto), HttpStatus.ACCEPTED);
	}

	@GetMapping("/menue/bill")
	public ResponseEntity<List<OrderResponseProjection>> generateBill(@RequestBody BillRequestDto billRequestDto) {
		return new ResponseEntity<List<OrderResponseProjection>>(orderService.generateBill(billRequestDto),
				HttpStatus.ACCEPTED);

	}

}
