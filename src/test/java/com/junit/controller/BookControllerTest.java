package com.junit.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.junit.entity.Book;
import com.junit.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BookControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	private BookController bookController;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Mock
	private BookRepository bookRepository;
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer();
	
	Book b = new Book(1, "social", "social_man");
	Book b1 = new Book(2, "Maths", "Ramanjun");
	Book b2 = new Book(3, "English", "jyothi");
	Book b3 = new Book(4, "science", "einsteen");
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	@Test
	public void getAllRecords_success() throws Exception {
		List<Book> books =  Arrays.asList(b, b1, b2, b3);
		
		when(bookRepository.findAll()).thenReturn(books);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/books/")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
		String content  = result.getResponse().getContentAsString();
		Book[] booksList = mapper.readValue(content, Book[].class);
		assertTrue(booksList.length > 0);
	}
	
	@Test
	public void post_body_success() throws Exception {
		
		Book b1 = new Book(5, "Maths-2", "Ramanjun-2");
		
		when(bookRepository.save(b1)).thenReturn(b1);
		
		String inputJson = mapper.writeValueAsString(b1);
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/books/persist")
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   //assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		  // assertEquals(content, "Book is created successfully");
	}
}
