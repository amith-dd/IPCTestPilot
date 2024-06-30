package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.swaraj.IPCTestPilot.dto.User;
import com.swaraj.IPCTestPilot.repo.UserRepo;

@Repository
public class UserDao {

    @Autowired
    private UserRepo repo;

    public User singupUser(User user) {
        return repo.save(user);
    }

    public User findUser(int userId) {
        Optional<User> optUser = repo.findById(userId);
        if(optUser.isPresent())
		{
			return optUser.get();
		}
		return null;
    }

    public List<User> findAllUser() {
        return repo.findAll();
    }

    public User deleteUser(int userId) {
    	User user = findUser(userId);
        if (user != null) {
            repo.delete(user);
            return user;
        }
        return null;
    }

    public User updateUser(User user, int userId) {
    	User dbUser = findUser(userId);
        if (dbUser != null) {
        	user.setUserId(userId);
            
            return repo.save(user);
        }
        return null;
    }
    
//    method to verify user email and password while login
    public boolean verifyUser(String email, String password) {
        Optional<User> optUser = repo.findByUserEmail(email);
        if (optUser.isPresent()) {
            User user = optUser.get();
            return user.getUserPassword().equals(password);
        }
        return false;
    }
    
 // method to find users by role
    public List<User> findUsersByRole(String role) {
        return repo.findByUserRole(role); 
    }
    
    /**
     * Finds and returns a list of users who are enrolled in a specific course.
     * <p>
     * This method filters the list of all users to find those who have the specified
     * course ID in their list of enrolled courses.
     * </p>
     *
     * @param courseId the ID of the course to search for
     * @return a list of {@link User} objects who are enrolled in the specified course
     */
    public List<User> findUsersByCourseId(int courseId) {
        List<User> users = findAllUser();
        return users.stream()
                    .filter(user -> user.getUserCourseIds().contains(courseId))
                    .collect(Collectors.toList());
    }



}
