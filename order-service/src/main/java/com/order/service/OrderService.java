package com.order.service;

import org.springframework.stereotype.Service;

import com.order.entity.Order;

@Service
public interface OrderService {

	void createOrder(Order order);

}
