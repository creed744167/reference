package com.food.java.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.java.dto.BillRequestDto;
import com.food.java.dto.FoodRequestDto;
import com.food.java.dto.OrderResponseDto;
import com.food.java.dto.OrderResponseProjection;
import com.food.java.entity.FoodItems;
import com.food.java.entity.OrderDetails;
import com.food.java.entity.User;
import com.food.java.exceptions.MadeupExceptions;
import com.food.java.repository.FoodRepository;
import com.food.java.repository.OrderRepository;
import com.food.java.repository.UserRepository;
import com.food.java.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	FoodRepository foodRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	public String placeOrder(FoodRequestDto foodRequestDto) {

		FoodItems foodItemId = foodRepository.findById(foodRequestDto.getFoodItemId()).get();
		double foodprice = foodItemId.getFoodprice();
		User user=new User();
		OrderDetails order = new OrderDetails();
		// List<OrderDetails>orderListS=new ArrayList<OrderDetails>();
		order.setOrderNumber(foodRequestDto.getOrderNumber());
		order.setFoodItem(foodItemId);
		order.setUser(user);
		order.setDateTime(LocalDateTime.now());
		order.setQuantity(foodRequestDto.getQuantity());
		order.setTotalPrice((foodprice) * (foodRequestDto.getQuantity()));
		BeanUtils.copyProperties(foodRequestDto, order);
		orderRepository.save(order);
		// ----------------------------------
		List<OrderResponseDto> orderlist = new ArrayList<OrderResponseDto>();
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		BeanUtils.copyProperties(order, orderlist);
		orderlist.add(orderResponseDto);
		return "Order Placed";
	}

	@Override
	public List<OrderResponseProjection> generateBill(BillRequestDto billRequestDto) {
		List<OrderResponseProjection> orderResponseProjList = orderRepository
				.findByOrderNumber(billRequestDto.getOrderNumber());
		return orderResponseProjList;
	}

	

}
