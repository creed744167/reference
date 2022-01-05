package com.food.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.java.dto.UserLogin;

import com.food.java.dto.UserResponseDto;
import com.food.java.dto.UserResponseProjection;
import com.food.java.entity.User;

@Service
public interface UserService {

	List<UserResponseProjection> getUserbyUsernameAndPassword(User user);

	List<UserResponseDto> getUsers();

	void saveUsers(User user);

	List<UserResponseDto> findById(Integer userId);

	

}
