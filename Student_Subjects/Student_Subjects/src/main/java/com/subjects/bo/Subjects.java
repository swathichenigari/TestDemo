package com.subjects.bo;

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
	
}
