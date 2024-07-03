package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.User;
import com.swaraj.IPCTestPilot.repo.UserRepo;

@Repository
public class UserDao {

    @Autowired
    private UserRepo repo;

    public User saveTrainer(User trainer) {
        return repo.save(trainer);
    }

    public User findTrainer(int trainerId) {
        Optional<User> optTrainer = repo.findById(trainerId);
        if(optTrainer.isPresent())
		{
			return optTrainer.get();
		}
		return null;
    }

    public List<User> findAllTrainers() {
        return repo.findAll();
    }

    public User deleteTrainer(int trainerId) {
    	User trainer = findTrainer(trainerId);
        if (trainer != null) {
            repo.delete(trainer);
            return trainer;
        }
        return null;
    }

    public User updateTrainer(User trainer, int trainerId) {
    	User dbTrainer = findTrainer(trainerId);
        if (dbTrainer != null) {
            trainer.setUserId(trainerId);
            
            return repo.save(trainer);
        }
        return null;
    }

    public List<User> findTrainersByCourse(int courseId) {
		return null;
        // Assuming you have a method in the repository or a custom query to find trainers by course ID
//        return repo.findByTrainerCourseIds(courseId);
    }


}
