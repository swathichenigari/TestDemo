package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderstatus_sequence_generator")
	@SequenceGenerator(name = "orderstatus_sequence_generator", allocationSize = 1, initialValue = 2, sequenceName = "orderstatus_sequence")
	private int id;
	private String status;
	
	public OrderStatus() {
		super();
	}
}
