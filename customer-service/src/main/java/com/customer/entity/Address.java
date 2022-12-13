package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "id")
	private int id;

	@JoinColumn(name = "street")
	private String street;

	@JoinColumn(name = "city")
	private String city;

	@JoinColumn(name = "province")
	private String province;

	@JoinColumn(name = "zipcode")
	private String zip;

	@JoinColumn(name = "country")
	private String country;

}
