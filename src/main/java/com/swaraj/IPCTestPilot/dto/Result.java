package com.swaraj.IPCTestPilot.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Component
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultId;
	private int studentId;
	private int quizId;
	private int marks;
}
