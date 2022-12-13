package com.order.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
		
	}

}
