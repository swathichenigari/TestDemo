package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
