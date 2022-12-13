package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.entity.Customer;

@Service
public interface CustomerService {

	public List<Customer> getAllCustomer();

	public void createCustomer(Customer customer);

	public Customer findCustomerById(int customerId);

	public void delete(int customerId);

	public Customer updateCustomerDetials(Customer customer);

}
