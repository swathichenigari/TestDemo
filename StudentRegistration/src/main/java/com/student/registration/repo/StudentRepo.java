package com.student.registration.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.registration.bo.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

}
