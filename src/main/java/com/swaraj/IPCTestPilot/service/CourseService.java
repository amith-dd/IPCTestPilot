package com.swaraj.IPCTestPilot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.CourseDao;
import com.swaraj.IPCTestPilot.entity.Course;
import com.swaraj.IPCTestPilot.entity.Subject;
import com.swaraj.IPCTestPilot.exception.CourseNotFoundException;
import com.swaraj.IPCTestPilot.exception.CourseNotSavedException;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class CourseService {

	@Autowired
	CourseDao dao;
	
	/*
	 * save course with subject id's
	 */
	public ResponseEntity<ResponseStructure<Course>> saveCourse(String courseName, List<Integer> subjectids) {
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setSubjectIds(subjectids);
		
		Course savedCourse = dao.saveCourse(course);
		if (savedCourse != null) {
			ResponseStructure<Course> structure = new ResponseStructure<Course>();
			structure.setData(savedCourse);
			structure.setMessage("course saved");
			structure.setStatus(HttpStatus.CREATED.value());//gives the code

			return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.CREATED);
		}
		throw new CourseNotSavedException("course save failed");
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses(){
		List<Course> courses = dao.getAll();
		if(courses.size()>0) {
			ResponseStructure<List<Course>> structure = new ResponseStructure<List<Course>>();
			structure.setData(courses);
			structure.setMessage("data found for all courses");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Course>>>(structure,HttpStatus.FOUND);
		}
		throw new CourseNotFoundException("course not found with the given ID");
	}
	
	/*
	 * get all subjects with given course id
	 */
	
	public ResponseEntity<ResponseStructure<List<String>>> getAllSubjectByCourseId(int courseId){
		Course course = dao.findCourse(courseId);
		if(course!=null) {
			List<String> subjects = new ArrayList<String>();
			List<Integer> subjectsIds = course.getSubjectIds();
			for(int i : subjectsIds) {
				subjects.add(Subject.values()[i].name());
			}
			ResponseStructure<List<String>> structure = new ResponseStructure<List<String>>();
			structure.setData(subjects);
			structure.setMessage("subjects found for given course Id");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<String>>>(structure,HttpStatus.FOUND);
		}
		throw new CourseNotFoundException("course not found with the given ID");
	}
	

}
