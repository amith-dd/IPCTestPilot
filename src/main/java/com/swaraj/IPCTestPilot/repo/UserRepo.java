package com.swaraj.IPCTestPilot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swaraj.IPCTestPilot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}