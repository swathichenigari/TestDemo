package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.entity.Address;

@Service
public interface AddressService {

	public void createAddress(Address address);

	public Address findAddressById(int addressId);

	public List<Address> getAllAdress();

}
