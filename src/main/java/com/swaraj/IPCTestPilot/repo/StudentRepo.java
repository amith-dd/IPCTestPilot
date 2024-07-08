package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	public Student findBystudentEmail(String email);
	
}
