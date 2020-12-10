package com.marks.dto;

import com.marks.bo.Subjects;

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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemeter() {
		return semeter;
	}
	public void setSemeter(int semeter) {
		this.semeter = semeter;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public Subjects getSubject() {
		return subject;
	}
	public void setSubject(Subjects subject) {
		this.subject = subject;
	}
	
}
