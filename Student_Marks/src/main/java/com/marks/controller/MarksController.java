package com.marks.controller;

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
import org.springframework.web.client.RestTemplate;

import com.marks.bo.Marks;
import com.marks.bo.Subjects;
import com.marks.dto.MarksDTO;
import com.marks.service.MarksService;


@RestController
@RequestMapping("/marks")
public class MarksController {

	@Autowired
	private MarksService marksService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("")
	public List<Marks> getMarks() {
		return marksService.getMarks();
	}
	
	@PostMapping("/saveMarks")
	public ResponseEntity<Marks> insertMarks(@Valid @RequestBody Marks marks) {
		marksService.insertMarks(marks);
		return new ResponseEntity<Marks>(marks, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteMarks/{id}")
	public ResponseEntity<Marks> deleteMarks(@PathVariable int id) {
		boolean isRemoved = marksService.deleteMarks(id);
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Marks>(HttpStatus.OK);
	}

	@PutMapping("/updateMarks")
	public ResponseEntity<Marks> updateMarks(@Valid@RequestBody Marks marksInfo) {
		marksService.updateMarks(marksInfo);
		return new ResponseEntity<Marks>(HttpStatus.OK);
	}
	
	@GetMapping("/std")
	public MarksDTO getMarksByStudentId(@RequestParam(value = "studentId", defaultValue = "1") int studentId) {
		Marks mark = marksService.getMarksbyStudentId(studentId);
		MarksDTO marksDto = new MarksDTO();
		Subjects subject = restTemplate.getForObject("http://studentsubjects/subjects/sub?subjectCode=" + mark.getSubjectCode(), Subjects.class);
		marksDto.setID(mark.getID());
		marksDto.setMarksObtained(mark.getMarksObtained());
		marksDto.setSemeter(mark.getSemester());
		marksDto.setStudentId(mark.getStudentId());
		marksDto.setSubject(subject);
		marksDto.setSubjectCode(mark.getSubjectCode());
		marksDto.setTotalMarks(mark.getTotalMarks());

		return marksDto;
	}
	
	@GetMapping("/{id}")
	public Marks getMarksById(@PathVariable int id) {
		return marksService.getMarksById(id);
	}
}
