package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Integer>{

	List<Trainer> findByTrainerCourseIds(int courseId);
	
	
}
