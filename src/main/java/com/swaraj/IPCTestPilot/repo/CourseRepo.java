package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Course;





public interface CourseRepo extends JpaRepository<Course, Integer>{
	
}
