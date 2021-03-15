package com.miu.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miu.finalProject.domain.Student;



@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	public List<Student> findAllByOrderByLastNameAsc();
}
