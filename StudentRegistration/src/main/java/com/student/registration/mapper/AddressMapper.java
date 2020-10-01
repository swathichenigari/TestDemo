package com.student.registration.mapper;

import org.mapstruct.Mapper;

import com.student.registration.bo.Address;
import com.student.registration.dto.AddressDTO;

@Mapper
public interface AddressMapper {

	Address dtotoentity(AddressDTO addressDto);
	
	AddressDTO entityToDto(Address address);

}
