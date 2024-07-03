package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Result;


public interface ResultRepo extends JpaRepository<Result, Integer>{

	List<Result> findAllById(int studentId);



}
