package com.product.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Category;
import com.product.entity.Product;
import com.product.exceptions.ResourceNotFoundException;
import com.product.service.ProductService;

@RestController
public class ProdcutController {

	@Autowired
	private ProductService productService;

	@PostConstruct
	public void postConstruct() {

		Category category = Category.builder().name("Electronics").build();

		Product product = Product.builder().addedOn(LocalDateTime.of(2022, Month.NOVEMBER, 3, 6, 30, 40, 50000))
				.updatedOn(LocalDateTime.of(2022, Month.NOVEMBER, 3, 6, 30, 40, 50000)).description("portable tv")
				.name("sony TV").price(10000.00).quantity("40X50").summary("portable TV with high resolution")
				.category(category).build();

		productService.createProduct(product);

	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@PostMapping("/createProduct")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("prodcut details were added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") int productId)
			throws ResourceNotFoundException {
		Product product = (Product) productService.findProductById(productId);
		if (product == null)
			new ResourceNotFoundException("Instructor not found :: " + productId);
		return ResponseEntity.ok().body(product);
	}

	@DeleteMapping("/product/{id}")
	public Map<String, String> deleteProductDetails(@PathVariable(value = "id") int productId)
			throws ResourceNotFoundException {
		Product product = (Product) productService.findProductById(productId);
		if (product == null)
			new ResourceNotFoundException("Product not found :: " + productId);

		productService.delete(product.getId());
		Map<String, String> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE.toString());
		response.put("status", HttpStatus.NO_CONTENT.toString());
		return response;
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProductDetails(@PathVariable(value = "id") int productId,
			@RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = (Product) productService.findProductById(productId);
		if (product == null)
			new ResourceNotFoundException("Instructor not found :: " + productId);
		product.setPrice(productDetails.getPrice());
		final Product updatedUser = productService.updateProductDetials(product);
		return ResponseEntity.ok(updatedUser);
	}

}
