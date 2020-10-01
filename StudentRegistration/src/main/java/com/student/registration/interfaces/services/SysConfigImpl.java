package com.student.registration.interfaces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.bo.City;
import com.student.registration.repo.ISysConfig;

@Service
public class SysConfigImpl {

	@Autowired
	private ISysConfig sysConfigRepo;
	
	public List<City> getAll(){
		return (List<City>) sysConfigRepo.findAll();
	}

}
