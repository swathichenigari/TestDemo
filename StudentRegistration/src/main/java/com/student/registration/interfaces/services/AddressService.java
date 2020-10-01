package com.student.registration.interfaces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.bo.Address;
import com.student.registration.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	
	public List<Address> getAddresses(){
		return (List<Address>) addressRepo.findAll();
	}
	
	public void insertAddress(Address address) {
		addressRepo.save(address);
	}
	
	public boolean deleteAddress(int id) {
		addressRepo.deleteById(id);
		return true;
	}

	public void updateAddress(Address addressInfo) {
		addressRepo.save(addressInfo);
	}
}
