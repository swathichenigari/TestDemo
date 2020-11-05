package com.student.registration.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	@NotBlank
	private String houseNo;
	private String city;
	@NotNull
	private String district;
	@NotNull
	private String state;
	private int pincode;
	
	public Address() {
		super();
	}
}
