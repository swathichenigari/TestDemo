package com.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
