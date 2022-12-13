package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
