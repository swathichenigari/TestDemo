package com.student.registration.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String name;
	private long mobileNo;
	private String gender;
	private Date dateofBirth;
	private String caste;
	@Min(15)
	@Max(20)
	private int age;
	private String relegion;
	@OneToOne
	@MapsId
	private Address address;

	public Student() {
		super();
	}

}
