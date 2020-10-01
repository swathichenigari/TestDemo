package com.student.registration.controller;

import java.util.List;

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

import com.student.registration.bo.Address;
import com.student.registration.bo.Student;
import com.student.registration.dto.StudentDTO;
import com.student.registration.interfaces.services.AddressService;
import com.student.registration.interfaces.services.StudentService;
import com.student.registration.mapper.StudentMapper;

@RestController
@RequestMapping("/api")
public class RestControllerAPI {
	
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AddressService addressService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/address")
	public List<Address> getAddress() {
		return addressService.getAddresses();
	}

	@PostMapping("/saveStudent")
	public boolean insertStudent(@RequestBody StudentDTO studentdto) {
		Student student = studentMapper.dtotoentity(studentdto);
		studentService.insertStudnet(student);
		return true;
	}

	@PostMapping("/saveAddress")
	public boolean insertStudent(@RequestBody Address address) {
		addressService.insertAddress(address);
		return true;
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
	public ResponseEntity<Address> updateAddress(@RequestBody Address addressInfo) {	
		addressService.updateAddress(addressInfo);
		return new ResponseEntity<Address>(HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentInfo) {	
		studentService.updateStudent(studentInfo);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
