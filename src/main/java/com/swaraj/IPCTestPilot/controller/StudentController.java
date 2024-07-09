package com.swaraj.IPCTestPilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.IPCTestPilot.dto.StudentDto;
import com.swaraj.IPCTestPilot.entity.Student;
import com.swaraj.IPCTestPilot.service.StudentService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(@RequestBody Student student){
		return service.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<StudentDto>> findStudent(@RequestParam  int studentId){
		return service.findStudent(studentId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<StudentDto>> deleteStudent(@RequestParam int studentId){
		return service.deleteStudent(studentId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(@RequestBody Student student,@RequestParam int studentId){
		return service.updateStudent(student, studentId);
	}
	
	@GetMapping("login")
	public ResponseEntity<ResponseStructure<StudentDto>> studentLogin(@RequestParam String email,@RequestParam String password){
		return service.studentLogin(email, password);
	}
	
	@GetMapping("all/{courseId}")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findStudentsByCourseId(@PathVariable int courseId){
		return service.findStudentsByCourseId(courseId);
	}
	
}
