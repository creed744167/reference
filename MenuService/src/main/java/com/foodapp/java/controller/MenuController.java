package com.foodapp.java.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.java.dto.MenuRequestDto;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;
import com.foodapp.java.service.MenuService;

@RestController
@Validated
public class MenuController {

	@Autowired
	MenuService menuService;

	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getFoodItems() {

		return new ResponseEntity<List<Menu>>(menuService.getFoodItems(), HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/menu/search/{foodName}")
	public ResponseEntity<List<MenuResponseProjection>> searchFood(@NotBlank(message="customerId cannot be null;") @PathVariable String foodName) {

		return new ResponseEntity<List<MenuResponseProjection>>(menuService.searchFood(foodName), HttpStatus.ACCEPTED);
	}
}
