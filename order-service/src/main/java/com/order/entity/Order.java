package com.order.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDateTime createdOn;
	
	@Default
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetails> orderDetailsList = new ArrayList<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Address deliveryAddress;
	
	private int customerId;
	
	@ManyToOne
	private OrderStatus status;
	
	public void addOrderDetails(OrderDetails orderDetails) {
		this.orderDetailsList.add(orderDetails);
		orderDetails.setOrder(this);
	}

	public void removeOrderDetails(OrderDetails orderDetails) {
		this.orderDetailsList.remove(orderDetails);
		orderDetails.setOrder(null);
	}
}
