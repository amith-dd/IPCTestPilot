package com.swaraj.IPCTestPilot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import com.swaraj.IPCTestPilot.dto.User;
=======
import com.swaraj.IPCTestPilot.entity.User;
>>>>>>> 03026fed75378094f4a1c201109b2d2a8c5855fd


;

public interface UserRepo extends JpaRepository<User, Integer>{
	// method to find users by email
	Optional<User> findByUserEmail(String userEmail);
	//  method to find users by role
	List<User> findByUserRole(int userRole);
	

}
