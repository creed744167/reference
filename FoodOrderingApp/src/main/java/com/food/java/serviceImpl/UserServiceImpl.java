package com.food.java.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.java.dto.UserLogin;

import com.food.java.dto.UserResponseDto;
import com.food.java.dto.UserResponseProjection;
import com.food.java.entity.User;
import com.food.java.repository.UserRepository;
import com.food.java.service.UserService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserResponseProjection> getUserbyUsernameAndPassword(User user) {
		
		List<UserResponseProjection> list = userRepository.findByUsernameAndPasswordContaining(user.getUsername(),
				user.getPassword());

		return list;

	}

	@Override
	public List<UserResponseDto> getUsers() {
		List<UserResponseDto> userList = new ArrayList<UserResponseDto>();
		Iterator<User> itt = userRepository.findAll().iterator();

		while (itt.hasNext()) {
			UserResponseDto userResponseDto = new UserResponseDto();
			BeanUtils.copyProperties(itt.next(), userResponseDto);
			userList.add(userResponseDto);
		}
		System.out.println(userList.size() + " " + userList.isEmpty());
		for (UserResponseDto s : userList) {
			System.out.print(s.getUsername());
		}
		return userList;
	}

	@Override
	public void saveUsers(User user) {
		User userr = new User();
		BeanUtils.copyProperties(user, userr);
		userRepository.save(userr);

	}

	@Override
	public List<UserResponseDto> findById(Integer userId) {
		System.out.println(userRepository.existsById(1));
		List<UserResponseDto> list = userRepository.findByUserId(userId);
		return list;

	}

}
