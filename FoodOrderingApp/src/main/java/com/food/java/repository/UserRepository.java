package com.food.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.java.dto.UserResponseDto;
import com.food.java.dto.UserResponseProjection;
import com.food.java.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<UserResponseProjection> findByUsernameAndPasswordContaining(String username, String password);

	List<UserResponseDto> findByUserId(Integer userId);

}
