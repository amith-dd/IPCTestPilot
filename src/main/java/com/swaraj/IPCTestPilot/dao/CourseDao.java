package com.swaraj.IPCTestPilot.dao;

import java.util.Optional;

import com.swaraj.IPCTestPilot.dto.Course;
import com.swaraj.IPCTestPilot.repo.CourseRepo;

public class CourseDao {
	
	CourseRepo repo;
	
	public Course saveCourse(Course course) {
		return repo.save(course);
	}
	
	public Course findCourse(int courseId) {
		Optional<Course> opcourse = repo.findById(courseId);
		if(opcourse.isPresent()) {
			return opcourse.get();
		}
		return null;
	}
	
	public Course deleteCourse(int courseId) {
		Course course = findCourse(courseId);
		if(course!=null) {
			repo.delete(course);
			return course;
		}
		return null;
	}
	
	public Course updateCourse(Course course, int courseId ) {
		Course dbcourse = findCourse(courseId);
		if(dbcourse!=null) {
			course.setCourseId(courseId);
			return repo.save(course);
		}
		return null;
	}
	
	
	
	
}
