package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer>{

}
