package com.order.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.entity.Product;
import com.order.fallback.FeignFallback;

@FeignClient(name="product-server" , fallback = FeignFallback.class)
public interface ProductClient {

	@GetMapping("/products")
	ResponseEntity<List<Product>> getAllProducts();
}
