package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}
