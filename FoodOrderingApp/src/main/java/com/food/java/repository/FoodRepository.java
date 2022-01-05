package com.food.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.java.dto.FoodResponseProjection;
import com.food.java.entity.FoodItems;

@Repository
public interface FoodRepository extends JpaRepository<FoodItems, Integer> {

	List<FoodResponseProjection> findByFoodNameContaining(String foodName);

	List<FoodResponseProjection> findByFoodtype(String foodtype);
}
