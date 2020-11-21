package com.student.registration.controller;

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
import org.springframework.web.client.RestTemplate;

import com.student.registration.bo.Address;
import com.student.registration.bo.Student;
import com.student.registration.dto.MarksDTO;
import com.student.registration.dto.StudentDTO;
import com.student.registration.interfaces.services.AddressService;
import com.student.registration.interfaces.services.StudentService;

@RestController
@RequestMapping("/api")
public class RestControllerAPI {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AddressService addressService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		studentService.getStudents().forEach(e-> e.setId(e.getAge()*2));
		return studentService.getStudents();
	}

	@GetMapping("/address")
	public List<Address> getAddress() {
		return addressService.getAddresses();
	}

	@PostMapping("/saveStudent")
	public ResponseEntity<Student> insertStudent(@Valid @RequestBody Student student) {
		studentService.insertStudnet(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping("/saveAddress")
	public ResponseEntity<Address> insertAddress(@Valid@RequestBody Address address) {
		addressService.insertAddress(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAddress/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable int id) {

		boolean isRemoved = addressService.deleteAddress(id);
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteStudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		boolean isRemoved = studentService.deleteStudent(id);
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<Address> updateAddress(@Valid@RequestBody Address addressInfo) {
		addressService.updateAddress(addressInfo);
		return new ResponseEntity<Address>(HttpStatus.OK);
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@Valid@RequestBody Student studentInfo) {
		studentService.updateStudent(studentInfo);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getStudentInfo/{id}")
	public StudentDTO getStudentInfo(@PathVariable int id) {
		Student student = studentService.getStudentById(id);
		StudentDTO dto = new StudentDTO();
		MarksDTO marks = restTemplate.getForObject("http://localhost:8082/marks/std?studentId=" + student.getId(),
				MarksDTO.class);
		dto.setMarks(marks);
		dto.setAddress(student.getAddress());
		dto.setAge(student.getAge());
		dto.setCaste(student.getCaste());
		dto.setDateofBirth(student.getDateofBirth());
		dto.setGender(student.getGender());
		dto.setMobileNo(student.getMobileNo());
		dto.setName(student.getName());
		dto.setRelegion(student.getRelegion());

		return dto;
	}

}
