package com.swaraj.IPCTestPilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.CourseDao;
import com.swaraj.IPCTestPilot.dto.Course;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class CourseService {

	@Autowired
	CourseDao dao;

	public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course) {

		Course savedCourse = dao.saveCourse(course);
		if (savedCourse != null) {

			ResponseStructure<Course> structure = new ResponseStructure<Course>();
			structure.setData(savedCourse);
			structure.setMessage("course saved");
			structure.setStatus(HttpStatus.CREATED.value());//gives the code

			return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.CREATED);

		}
		return null;

	}
	
	

}
