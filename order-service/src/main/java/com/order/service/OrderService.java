package com.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.entity.Order;

@Service
public interface OrderService {

	void createOrder(Order order);

	List<Order> getOrders();
	
	

}
