package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StudentEntity;
import com.example.repo.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	private StudentRepository repository;

	@Override
	public String saveStudent(StudentEntity entity) {
		
		repository.save(entity);
		
		return "student details saved succesfully";
	}

	@Override
	public List<StudentEntity> getStudents() {
		return repository.findAll();
	}

	  @Override
	    public StudentEntity getStudentById(Integer id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
	    }

	@Override
	public String deleteById(Integer id) {
		
		 repository.deleteById(id);
		 
		return null;		
	
	}

}
