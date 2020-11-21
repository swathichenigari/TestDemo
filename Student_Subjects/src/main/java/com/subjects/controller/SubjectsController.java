package com.subjects.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subjects.bo.Subjects;
import com.subjects.service.SubjectsService;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

	@Autowired
	private SubjectsService subjectsService;
	
	@GetMapping("/")
	public List<Subjects> getSubjects() {
		return subjectsService.getSubjects();
	}
	
	@GetMapping("/{id}")
	public Subjects getSubjects(@PathVariable int id) {
		return subjectsService.getById(id);
	}
	
	@GetMapping("/sub")
	public Subjects getSubject(@RequestParam(value = "subjectCode", defaultValue = "CS01") String subjectCode) {
		return subjectsService.getSubjectByCode(subjectCode);
	}
	
	@PostMapping("/saveSubjects")
	public ResponseEntity<Subjects> insertSubjects(@Valid @RequestBody Subjects subjects) {
		subjectsService.insertSubjects(subjects);
		return new ResponseEntity<Subjects>(subjects, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteSubjects/{id}")
	public ResponseEntity<Subjects> deleteSubjects(@PathVariable int id) {
		boolean isRemoved = subjectsService.deleteSubjects(id);
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Subjects>(HttpStatus.OK);
	}

	@PutMapping("/updateSubjects")
	public ResponseEntity<Subjects> updateSubjects(@Valid@RequestBody Subjects subjectsInfo) {
		subjectsService.updateSubjects(subjectsInfo);
		return new ResponseEntity<Subjects>(HttpStatus.OK);
	}
	
	
}
