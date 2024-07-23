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
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int responseId;
	int quizId;
	int studentId;
	int mark;
	@ElementCollection
	List<String> answers;

}
