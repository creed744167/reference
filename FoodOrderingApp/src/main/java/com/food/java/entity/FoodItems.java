package com.food.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class FoodItems {
    
	@Id
	private Integer foodItemId;
	private String foodName;
	private double foodprice;
	private String foodtype;
	public Integer getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(Integer foodItemId) {
		this.foodItemId = foodItemId;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	
	
	
	
	
}
