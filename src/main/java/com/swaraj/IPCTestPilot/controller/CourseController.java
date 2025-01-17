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

import com.swaraj.IPCTestPilot.entity.Course;
import com.swaraj.IPCTestPilot.service.CourseService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService service;
	 
	@PostMapping
	@Operation(summary = "Save Course Details")
	public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestParam String courseName,@RequestBody List<Integer> subjectids){
		return service.saveCourse(courseName, subjectids);
	}
	 
	@GetMapping("getall")
	@Operation(summary = "Get All Course Details")
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses(){
		return service.getAllCourses();
	}

	@Operation(summary = "Getting All Subjects By Course ID")
	@GetMapping("/{courseId}")
	public ResponseEntity<ResponseStructure<List<String>>> getAllSubjectByCourseId(@PathVariable int courseId){
		return service.getAllSubjectByCourseId(courseId);
	}
	
	@Operation(summary = "delete By Course ID")
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ResponseStructure<Course>> deleteCourseById(@PathVariable int courseId){
		return service.deleteCource(courseId);
	}
	
	@Operation(summary = "update Course By Course ID")
	@PutMapping
	public ResponseEntity<ResponseStructure<Course>> deleteCourseById(@RequestBody Course course ,@RequestParam int courseId){
		return service.updateCource(course, courseId);
	}
	
}
