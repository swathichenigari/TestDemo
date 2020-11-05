package com.subjects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subjects.bo.Subjects;
import com.subjects.repo.SubjectsRepo;

@Service
public class SubjectsService {
	
	@Autowired
	private SubjectsRepo subjectsRepo;

	public List<Subjects> getSubjects(){
		return subjectsRepo.findAll();
	}
	
	public void insertSubjects(Subjects subjects) {
		subjectsRepo.save(subjects);
	}
	
	public boolean deleteSubjects(int id) {
		subjectsRepo.deleteById(id);
		return true;
	}

	public void updateSubjects(Subjects subjectsInfo) {
		subjectsRepo.save(subjectsInfo);
	}
	
}
