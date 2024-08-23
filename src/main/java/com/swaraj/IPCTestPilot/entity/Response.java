package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Component
@Entity
@Data
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int responseId;
	
	@Positive(message = "The Quiz Id must be a Positive Number")
	int quizId;
	
	@Positive(message = "The Student Id must be a Positive Number")
	int studentId;
	
	@Positive(message = "Mark must be a Positive Number")
	int mark;
	
	@ElementCollection
	List<String> answers;

}
