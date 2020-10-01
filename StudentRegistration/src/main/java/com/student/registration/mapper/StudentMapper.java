package com.student.registration.mapper;

import org.mapstruct.Mapper;

import com.student.registration.bo.Student;
import com.student.registration.dto.StudentDTO;

@Mapper(imports = { AddressMapper.class })
public interface StudentMapper {

	public Student dtotoentity(StudentDTO studentDto);
	
	public StudentDTO entityToDto(Student student);
	
}
