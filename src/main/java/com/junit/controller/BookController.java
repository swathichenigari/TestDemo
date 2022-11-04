package com.junit.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.entity.Book;
import com.junit.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostConstruct
	public void setup() {
		Book b = new Book(1, "social", "social_man");
		Book b1 = new Book(2, "Maths", "Ramanjun");
		Book b2 = new Book(3, "English", "jyothi");
		Book b3 = new Book(4, "science", "einsteen");

		List<Book> books = Arrays.asList(b, b1, b2, b3);

		bookRepository.saveAll(books);
	}

	@GetMapping("/")
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookRepository.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@PostMapping("/persist")
	public ResponseEntity<Book> persistBooks(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookRepository.save(book), HttpStatus.CREATED);

	}
}
