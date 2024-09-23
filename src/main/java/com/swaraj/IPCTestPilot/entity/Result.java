package com.swaraj.IPCTestPilot.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Component
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultId;
	
	@Positive(message = "The Student Id must be a Positive Number")
	private int studentId;
	
	@Positive(message = "The Quiz Id must be a Positive Number")
	private int quizId;
	
	@Positive(message = "Marks must be a Positive Number")
	private int marks;
}
