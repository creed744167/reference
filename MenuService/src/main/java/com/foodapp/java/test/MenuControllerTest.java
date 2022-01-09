package com.foodapp.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.foodapp.java.controller.MenuController;
import com.foodapp.java.entity.Menu;
import com.foodapp.java.repository.MenuRepository;
import com.foodapp.java.serviceImpl.MenuServiceImpl;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MenuControllerTest {
	
	@InjectMocks
	Menu menu;
	
	@Mock
	MenuController menuController;
	
	@BeforeEach
	public void startUp() {
		menu=new Menu();
		menu.setFoodItemId(101);
		menu.setFoodName("Laddo");
		menu.setFoodprice(20);
		menu.setFoodtype("veg");
	}
	
	@Test
	public void getFoodItems() {
		ResponseEntity list=new ResponseEntity<List<Menu>>(HttpStatus.ACCEPTED) ;
		when(menuController.getFoodItems()).thenReturn(list);
		ResponseEntity<List<Menu>> actualList=menuController.getFoodItems();
		assertEquals(list, actualList);
		}
	
	
	@Test
	public void searchFood(){
		
	}
	
	

}
