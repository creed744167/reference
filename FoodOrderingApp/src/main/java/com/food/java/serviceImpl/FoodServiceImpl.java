package com.food.java.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.java.dto.FoodResponseProjection;
import com.food.java.entity.FoodItems;
import com.food.java.exceptions.MadeupExceptions;
import com.food.java.repository.FoodRepository;
import com.food.java.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository foodRepo;

	@Override
	public List<FoodItems> getFoodItems() {

		List<FoodItems> foodItemList = new ArrayList<FoodItems>();
		Iterator<FoodItems> itt = foodRepo.findAll().iterator();

		while (itt.hasNext()) {
			FoodItems foodItems = new FoodItems();
			BeanUtils.copyProperties(itt.next(), foodItems);
			foodItemList.add(foodItems);
		}
		return foodItemList;

	}

	@Override
	public List<FoodResponseProjection> searchFood(FoodItems foodItems) {
		List<FoodResponseProjection> FoodList = foodRepo.findByFoodNameContaining(foodItems.getFoodName());
		if (FoodList.isEmpty())
			throw new MadeupExceptions("Food Not Available: " + foodItems.getFoodName());
		return FoodList;
	}

	@Override
	public List<FoodResponseProjection> searchFoodByType(FoodItems foodItems) {
		List<FoodResponseProjection> FoodList = foodRepo.findByFoodtype(foodItems.getFoodtype());
		if (FoodList.isEmpty())
			throw new MadeupExceptions(foodItems.getFoodtype() + " Not Available as of now");
		return FoodList;
	}

}
