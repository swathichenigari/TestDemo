package com.customer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.entity.Address;
import com.customer.repository.AddressRepository;
import com.customer.service.AddressService;

@Component
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void createAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public Address findAddressById(int addressId) {
		return addressRepository.findById(addressId).get();
	}

	@Override
	public List<Address> getAllAdress() {
		return addressRepository.findAll();
	}

}
