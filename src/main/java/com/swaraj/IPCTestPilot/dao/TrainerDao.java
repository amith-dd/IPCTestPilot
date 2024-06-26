package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.dto.Trainer;
import com.swaraj.IPCTestPilot.repo.TrainerRepo;

@Repository
public class TrainerDao {

    @Autowired
    private TrainerRepo repo;

    public Trainer saveTrainer(Trainer trainer) {
        return repo.save(trainer);
    }

    public Trainer findTrainer(int trainerId) {
        Optional<Trainer> optTrainer = repo.findById(trainerId);
        if(optTrainer.isPresent())
		{
			return optTrainer.get();
		}
		return null;
    }

    public List<Trainer> findAllTrainers() {
        return repo.findAll();
    }

    public Trainer deleteTrainer(int trainerId) {
        Trainer trainer = findTrainer(trainerId);
        if (trainer != null) {
            repo.delete(trainer);
            return trainer;
        }
        return null;
    }

    public Trainer updateTrainer(Trainer trainer, int trainerId) {
        Trainer dbTrainer = findTrainer(trainerId);
        if (dbTrainer != null) {
            trainer.setTrainerId(trainerId);
            
            return repo.save(trainer);
        }
        return null;
    }

    public List<Trainer> findTrainersByCourse(int courseId) {
        // Assuming you have a method in the repository or a custom query to find trainers by course ID
        return repo.findByTrainerCourseIds(courseId);
    }


}
