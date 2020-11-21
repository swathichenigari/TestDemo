package com.subjects.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subjects.bo.Subjects;

@Repository
public interface SubjectsRepo extends JpaRepository<Subjects, Integer> {
	

}
