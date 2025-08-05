package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.StudentResponse;
import com.example.entity.StudentEntity;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/addstudent")
 	public ResponseEntity<String>  saveStudentDetails(@RequestBody StudentEntity entity) {
		
		
	return new ResponseEntity<>("Student details saved successfully",HttpStatus.CREATED) ;
		
 	}
	
	@GetMapping("/all_students")
	public ResponseEntity<List<StudentEntity>> getStudentsList() {
		List<StudentEntity> students = service.getStudents();
		
		return new ResponseEntity<>(students,HttpStatus.CREATED);
	}
	
	@GetMapping("/student_by_id/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id) {
		StudentEntity student = service.getStudentById(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete_student_by_id/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
		service.deleteById(id);
		return new ResponseEntity<>("Student deleted Successfully",HttpStatus.OK);
	}
	
	
	

}
