package com.marks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marks.bo.Marks;

@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer>{

}
