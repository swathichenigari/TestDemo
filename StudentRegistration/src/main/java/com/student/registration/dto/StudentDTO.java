package com.student.registration.dto;

import java.util.Date;


public class StudentDTO {

	private int id;

	private String name;

	private long mobileNo;

	private String gender;

	private Date dateofBirth;

	private String caste;

	private int age;

	private String relegion;

	private AddressDTO addressDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRelegion() {
		return relegion;
	}

	public void setRelegion(String relegion) {
		this.relegion = relegion;
	}

	public AddressDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDTO addressDto) {
		this.addressDto = addressDto;
	}
	
	
}
