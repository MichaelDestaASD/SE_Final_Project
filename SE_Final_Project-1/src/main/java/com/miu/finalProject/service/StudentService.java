package com.miu.finalProject.service;

import java.util.List;

import com.miu.finalProject.domain.Student;



public interface StudentService {
public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theEmployee);
	
	public void deleteById(int theId);
}
