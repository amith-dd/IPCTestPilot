package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Entity
@Data
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	private String trainerName;
	private long trainerContact;
	private String trainerEmail;
	private String trainerPassword;
	@ElementCollection
	private List<Integer> trainerCourseIds;
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public long getTrainerContact() {
		return trainerContact;
	}
	public void setTrainerContact(long trainerContact) {
		this.trainerContact = trainerContact;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public String getTrainerPassword() {
		return trainerPassword;
	}
	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}
	public List<Integer> getTrainerCourseIds() {
		return trainerCourseIds;
	}
	public void setTrainerCourseIds(List<Integer> trainerCourseIds) {
		this.trainerCourseIds = trainerCourseIds;
	}
	
	
	
	
}
