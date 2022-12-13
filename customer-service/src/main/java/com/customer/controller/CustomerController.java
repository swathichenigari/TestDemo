package com.customer.controller;

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

import com.customer.entity.Address;
import com.customer.entity.Customer;
import com.customer.exceptions.ResourceNotFoundException;
import com.customer.service.AddressService;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;

	@PostConstruct
	public void postConstructCustomerDetails() {

		Address address = new Address();
		address.setCity("secunderabad");
		address.setCountry("india");
		address.setProvince("province");
		address.setStreet("lalapet");
		address.setZip("500017");

		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setEmail("chenigariswathi@gmail.com");
		customer.setFirstname("swathi");
		customer.setLastname("chenigari");
		customer.setPhone("9949256098");

		customerService.createCustomer(customer);

	}

	// Get all customers
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customerList = customerService.getAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return new ResponseEntity<>("customer details were added", HttpStatus.CREATED);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(
			@PathVariable(value = "id") int customerId) throws ResourceNotFoundException  {
		Customer customer = (Customer) customerService.findCustomerById(customerId);
		if (customer == null)
			new ResourceNotFoundException("Instructor not found :: " + customerId);
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping("/customer/{id}")
	public Map<String, Boolean> deleteCustomerDetails(
			@PathVariable(value = "id") int customerId) throws ResourceNotFoundException  {
		Customer customer = (Customer) customerService.findCustomerById(customerId);
		if (customer == null)
			new ResourceNotFoundException("Instructor not found :: "+ customerId);

		customerService.delete(customer.getId());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/instructors/{id}")
	public ResponseEntity<Customer> updateCustomerDetails(@PathVariable(value = "id") int customerId,
			@RequestBody Customer customerDetails)  throws ResourceNotFoundException  {
		Customer customer = (Customer) customerService.findCustomerById(customerId);
		if (customer == null)
				new ResourceNotFoundException("Instructor not found :: " + customerId);
		customer.setEmail(customerDetails.getEmail());
		final Customer updatedUser = customerService.updateCustomerDetials(customer);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(
			@PathVariable(value = "id") int addressId) throws ResourceNotFoundException  {
		Address address = (Address) addressService.findAddressById(addressId);
		if (address == null)
			new ResourceNotFoundException("Instructor not found :: " + addressId);
		return ResponseEntity.ok().body(address);
	}

	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress() {
		List<Address> addressList = addressService.getAllAdress();
		return new ResponseEntity<>(addressList, HttpStatus.OK);
	}
}
