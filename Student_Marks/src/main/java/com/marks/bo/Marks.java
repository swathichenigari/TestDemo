package com.marks.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private int studentId;
	private int semester;
	private String subjectCode;
	private int totalMarks;
	private int marksObtained;
}
