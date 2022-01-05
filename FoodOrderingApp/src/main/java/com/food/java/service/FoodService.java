package com.food.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.java.dto.FoodResponseProjection;
import com.food.java.entity.FoodItems;

@Service
public interface FoodService {

	List<FoodItems> getFoodItems();

	List<FoodResponseProjection> searchFood(FoodItems foodItems);

	List<FoodResponseProjection> searchFoodByType(FoodItems foodItems);

}
