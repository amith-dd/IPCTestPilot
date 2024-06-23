package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
