package com.student.registration.dto;


import com.student.registration.bo.Subjects;

import lombok.Data;

@Data
public class MarksDTO {

	private int ID;
	private int studentId;
	private int semeter;
	private String subjectCode;
	private int totalMarks;
	private int marksObtained;
	private Subjects subject;
}
