package com.foodapp.java.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.java.dto.MenuRequestDto;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;
import com.foodapp.java.exception.SelfMadeExceptions;
import com.foodapp.java.repository.MenuRepository;
import com.foodapp.java.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepo;

	@Override
	public List<Menu> getFoodItems() {

		List<Menu> foodItemList = new ArrayList<Menu>();
		Iterator<Menu> itt = menuRepo.findAll().iterator();
		while (itt.hasNext()) {
			Menu foodItems = new Menu();
			BeanUtils.copyProperties(itt.next(), foodItems);
			foodItemList.add(foodItems);
		}
		return foodItemList;

	}

	@Override
	public List<MenuResponseProjection> searchFood(String foodName) {
		List<MenuResponseProjection> FoodList = menuRepo.findByFoodNameContaining(foodName);
        if(FoodList.isEmpty()) {throw new SelfMadeExceptions("No food with name "+foodName+" found");}
		return FoodList;
	}

}
