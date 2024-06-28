package com.swaraj.IPCTestPilot.dto;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Component
public class Result {
	private int studentId;
	private int quizId;
	private int marks;
}
