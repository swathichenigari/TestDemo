package com.marks.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(unique = true)
	private String subjectCode;
	private String sub_name;
	private String sub_description;
	private String branch;
	private int semester;
	private String optional_sub;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_description() {
		return sub_description;
	}
	public void setSub_description(String sub_description) {
		this.sub_description = sub_description;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getOptional_sub() {
		return optional_sub;
	}
	public void setOptional_sub(String optional_sub) {
		this.optional_sub = optional_sub;
	}
	
	
	
}
