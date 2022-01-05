package com.food.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.java.dto.UserLogin;

import com.food.java.dto.UserResponseDto;
import com.food.java.dto.UserResponseProjection;
import com.food.java.entity.FoodItems;
import com.food.java.entity.User;
import com.food.java.repository.UserRepository;
import com.food.java.service.FoodService;
import com.food.java.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	FoodService foodService;

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserResponseDto> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/users")
	public ResponseEntity<String> saveUsers(@RequestBody User user) {
		userService.saveUsers(user);
		return new ResponseEntity<String>("User Saved", HttpStatus.ACCEPTED);
	}

	@PostMapping("/users/login")
	public ResponseEntity<List<UserResponseProjection>> accountLogin(@RequestBody User user) {
		return new ResponseEntity<List<UserResponseProjection>>(userService.getUserbyUsernameAndPassword(user),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<UserResponseDto>> findById(@RequestParam Integer userId) {
		return new ResponseEntity<List<UserResponseDto>>(userService.findById(userId), HttpStatus.ACCEPTED);
	}

}
