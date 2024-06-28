package com.swaraj.IPCTestPilot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swaraj.IPCTestPilot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByUserEmail(String userEmail);

}
