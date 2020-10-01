package com.student.registration.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.registration.bo.City;

@Repository
public interface ISysConfig extends CrudRepository<City, Integer>{

}
