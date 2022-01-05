package com.food.java.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.food.java.entity.FoodItems;

public class OrderResponseDto {

	private Integer userId;
	private Integer foodItemId;
	private List<FoodItems> foodItems;
	private int quantity;
	private int orderNumber;
	private LocalDateTime dateTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(Integer foodItemId) {
		this.foodItemId = foodItemId;
	}
	public List<FoodItems> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
