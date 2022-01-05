package com.food.java.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.food.java.entity.FoodItems;

public interface OrderBillResponserProjection {
	String getFoodName();
	int getQuantity();
	int getOrderNumber();
	LocalDateTime getDateTime();
	double getTotalPrice();
}
