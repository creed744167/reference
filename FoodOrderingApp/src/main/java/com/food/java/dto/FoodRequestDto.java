package com.food.java.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class FoodRequestDto {
	
	
	@NotNull(message="orderNumber cannot be empty")
	private int orderNumber;
	@NotNull(message="Enter the userId")
	private Integer userId;
	@NotNull(message="Enter the foodItemId")
	private Integer foodItemId;
	@NotNull(message="Enter the quantity")
	private int quantity;
	
	
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public int getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setFoodItemId(Integer foodItemId) {
		this.foodItemId = foodItemId;
	}
	
	
	
	
}
