package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
