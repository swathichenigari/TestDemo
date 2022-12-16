package com.order.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Address;
import com.order.entity.Customer;
import com.order.entity.Order;
import com.order.entity.OrderDetails;
import com.order.entity.OrderStatus;
import com.order.entity.Product;
import com.order.repository.OrderDetailsRepository;
import com.order.repository.OrderStatusRepository;
import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	ProductClient productClient;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	
	@PostConstruct
	public void postConstruct() {
		OrderStatus status = OrderStatus.builder().status("pending").build();
		orderStatusRepository.save(status);
		
	}
	
	
	@PostMapping("/createOrder/{customerId}")
	public void createOrderForCustomer(@PathVariable int customerId) {

		Address customerAddress = template.getForObject("http://customer-server/address/2", Address.class);
		ResponseEntity<Product[]> productList = template.getForEntity("http://product-server/products", Product[].class);
		List<Product> products = Arrays.asList(productList.getBody());
		
		
		OrderDetails orderDetails = OrderDetails.builder()
				.orderedQuantity("2")
				.price(50000)
				.productId(products.stream().findFirst().get().getId()).build();
		
		OrderDetails orderDetails1 = OrderDetails.builder()
				.orderedQuantity("1")
				.price(50000)
				.productId(products.stream().findFirst().get().getId()).build();
		
		OrderStatus status = orderStatusRepository.findById(2).get();
		
		Order order = Order.builder().createdOn(LocalDateTime.of(2022, Month.NOVEMBER, 3, 6, 30, 40, 50000))
				.customerId(customerId)
				.deliveryAddress(customerAddress)
				.status(status).build();
		
		order.addOrderDetails(orderDetails1);
		order.addOrderDetails(orderDetails);
		
		orderService.createOrder(order);
		
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/orders/prodcuts")
	public List<Product> getProductsInsideOrder(){
		ResponseEntity<Product[]> productList = template.getForEntity("http://product-server/products", Product[].class);
		List<Product> products = Arrays.asList(productList.getBody());
		return products;
	}
	
	@GetMapping("/orders/prodcuts-feign")
	public ResponseEntity<List<Product>> getProductsFeign(){
		System.out.println("using feign clinet");
		return productClient.getAllProducts();
	}


}
