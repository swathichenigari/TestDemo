package com.student.registration.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.registration.bo.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer>{

}
