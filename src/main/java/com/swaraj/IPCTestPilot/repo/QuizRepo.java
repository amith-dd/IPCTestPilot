package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.entity.Quiz;

;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{
	 
}
