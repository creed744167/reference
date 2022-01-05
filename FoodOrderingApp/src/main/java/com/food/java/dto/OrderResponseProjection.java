package com.food.java.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.food.java.entity.FoodItems;

public interface OrderResponseProjection {
	
	FoodItems getFoodItem();
	int getQuantity();
	int getOrderNumber();
	double getTotalPrice();
	LocalDateTime getDateTime();
	

	
}
