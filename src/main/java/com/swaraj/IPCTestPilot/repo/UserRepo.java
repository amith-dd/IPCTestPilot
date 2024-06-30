package com.swaraj.IPCTestPilot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swaraj.IPCTestPilot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	// method to find users by email
	Optional<User> findByUserEmail(String userEmail);
	//  method to find users by role
	List<User> findByUserRole(String userRole);

}
