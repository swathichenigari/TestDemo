package com.product.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodcutRepository;

	@Override
	public List<Product> getAllProducts() {
		return prodcutRepository.findAll();
	}

	@Override
	public void createProduct(Product product) {
		prodcutRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) {
		return prodcutRepository.findById(productId).get();
	}

	@Override
	public void delete(int id) {
		prodcutRepository.deleteById(id);
	}

	@Override
	public Product updateProductDetials(Product product) {
		return prodcutRepository.save(product);
	}

}
