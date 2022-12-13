package com.customer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.AddressService;
import com.customer.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Override
	public void delete(int customerId) {
		 customerRepository.deleteById(customerId);
	}

	@Override
	public Customer updateCustomerDetials(Customer customer) {
		return customerRepository.save(customer);
	}

}
