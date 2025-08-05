package com.example.service;

import java.util.List;

import com.example.entity.StudentEntity;

public interface StudentService {
	
	public String  saveStudent(StudentEntity request);
	
	public List<StudentEntity> getStudents();
	
	 public StudentEntity getStudentById(Integer id);
	 
	 public  String deleteById(Integer id);       

}
