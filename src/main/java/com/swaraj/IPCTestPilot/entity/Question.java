package com.swaraj.IPCTestPilot.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Entity
@Data
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private int subjectId;
	 @JsonProperty("questionContent")
	private String questionContent;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD; 
	private String correctAnswer; 
	
	
	
}
