package com.subjects.bo;

import java.util.List;

import lombok.Data;

@Data
public class SubjectsList {

	private List<Subjects> subjects;

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

}
