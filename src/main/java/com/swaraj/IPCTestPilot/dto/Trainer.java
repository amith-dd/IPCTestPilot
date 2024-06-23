package com.swaraj.IPCTestPilot.dto;

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
	
}
