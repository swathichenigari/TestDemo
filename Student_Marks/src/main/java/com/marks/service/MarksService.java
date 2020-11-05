package com.marks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.bo.Marks;
import com.marks.repo.MarksRepo;

@Service
public class MarksService {

	@Autowired
	private MarksRepo marksRepo;
	
	public List<Marks> getMarks(){
		return marksRepo.findAll();
	}
	
	public void insertMarks(Marks marks) {
		marksRepo.save(marks);
	}
	
	public boolean deleteMarks(int id) {
		marksRepo.deleteById(id);
		return true;
	}

	public void updateMarks(Marks marksInfo) {
		marksRepo.save(marksInfo);
	}
	
}
