package com.student.registration.interfaces.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.bo.Student;
import com.student.registration.exceptions.NoSuchStudent;
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
		Optional<Student> st = studentRepo.findById(id);
		if(!st.isPresent()) {
			throw new NoSuchStudent("Not found");
		}
		studentRepo.deleteById(id);
		return true;
	}

	public void updateStudent(Student studentInfo) {
		Optional<Student> st = studentRepo.findById(studentInfo.getId());
		if(!st.isPresent()) {
			throw new NoSuchStudent("Not found");
		}
		studentRepo.save(studentInfo);
	}
	
	public Optional<Student> getStudentById(int id) {
		Optional<Student> st = studentRepo.findById(id);
		if(!st.isPresent()) {
			throw new NoSuchStudent("Not found");
		}
		return st;
	}
}
