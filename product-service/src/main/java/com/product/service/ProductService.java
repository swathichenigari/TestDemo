package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.entity.Product;

@Service
public interface ProductService {

	List<Product> getAllProducts();

	void createProduct(Product customer);

	Product findProductById(int productId);

	void delete(int id);

	Product updateProductDetials(Product product);

}
