package com.marks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marks.bo.Marks;
import com.marks.service.MarksService;


@RestController
@RequestMapping("/marks")
public class MarksController {

	@Autowired
	private MarksService marksServic;
	
	@GetMapping("/")
	public List<Marks> getMarkss() {
		return marksServic.getMarks();
	}
	
	@PostMapping("/saveMarks")
	public ResponseEntity<Marks> insertMarks(@Valid @RequestBody Marks marks) {
		marksServic.insertMarks(marks);
		return new ResponseEntity<Marks>(marks, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteMarks/{id}")
	public ResponseEntity<Marks> deleteMarks(@PathVariable int id) {
		boolean isRemoved = marksServic.deleteMarks(id);
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Marks>(HttpStatus.OK);
	}

	@PutMapping("/updateMarks")
	public ResponseEntity<Marks> updateMarks(@Valid@RequestBody Marks marksInfo) {
		marksServic.updateMarks(marksInfo);
		return new ResponseEntity<Marks>(HttpStatus.OK);
	}
	
	
}
