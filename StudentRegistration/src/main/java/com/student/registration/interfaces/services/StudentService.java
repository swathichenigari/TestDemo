package com.student.registration.interfaces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.bo.Address;
import com.student.registration.bo.Student;
import com.student.registration.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getStudents() {
		return (List<Student>) studentRepo.findAll();
	}
	
	public void insertStudnet(Student student) {
		studentRepo.save(student);
	}
	
	public boolean deleteStudent(int id) {
		studentRepo.deleteById(id);
		return true;
	}

	public void updateStudent(Student studentInfo) {
		studentRepo.save(studentInfo);
		
	}
}
