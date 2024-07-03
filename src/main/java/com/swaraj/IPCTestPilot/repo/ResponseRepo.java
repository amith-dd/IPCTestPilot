package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.IPCTestPilot.dto.Response;

public interface ResponseRepo extends JpaRepository<Response, Integer> {

	
}
