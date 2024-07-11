package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 8cb4867ef9cb85fb9ceb80aa42344626f72d37b4
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Course;
import com.swaraj.IPCTestPilot.repo.CourseRepo;
<<<<<<< HEAD
=======

>>>>>>> 8cb4867ef9cb85fb9ceb80aa42344626f72d37b4
@Repository
public class CourseDao {
	
	@Autowired
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
	
	public List<Course> getAll(){
		List<Course> courses = repo.findAll();
		if(courses.size()>0) {
			return courses;
		}
		return null;
	}
	
	
	
}
