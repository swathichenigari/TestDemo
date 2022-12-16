package com.order.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.order.controller.ProductClient;
import com.order.entity.Product;

public class FeignFallback implements ProductClient{

	@Override
	public ResponseEntity<List<Product>> getAllProducts() {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}

}
