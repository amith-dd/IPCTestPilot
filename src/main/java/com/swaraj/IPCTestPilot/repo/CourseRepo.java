package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{
	
}
