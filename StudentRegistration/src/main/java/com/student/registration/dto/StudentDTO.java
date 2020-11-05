package com.student.registration.dto;

import java.util.Date;

import com.student.registration.bo.Address;

import lombok.Data;

@Data
public class StudentDTO {

	private int id;
	private String name;
	private long mobileNo;
	private String gender;
	private Date dateofBirth;
	private String caste;
	private int age;
	private String relegion;
	private Address address;

}
