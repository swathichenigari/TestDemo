package com.order.serviceimpl;

import java.util.List;

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

	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

}
