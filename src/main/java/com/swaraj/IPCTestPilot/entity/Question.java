package com.swaraj.IPCTestPilot.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Component
@Entity
@Data
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	@Positive(message = "Subject Id should be a Positive Number")
	private int subjectId;
	
	@NotBlank(message = "Question Cannot Be Blank")
	@NotNull(message = "Question Cannot Be Null")
	private String question;
	
	@NotBlank(message = "Options Cannot Be Blank")
	@NotNull(message = "Options Cannot Be Null")
	private String optionA;
	
	@NotBlank(message = "Options Cannot Be Blank")
	@NotNull(message = "Options Cannot Be Null")
	private String optionB;
	
	@NotBlank(message = "Options Cannot Be Blank")
	@NotNull(message = "Options Cannot Be Null")
	private String optionC;
	
	@NotBlank(message = "Options Cannot Be Blank")
	@NotNull(message = "Options Cannot Be Null")
	private String optionD; 
	
	@NotBlank(message = "Answer Cannot Be Blank")
	@NotNull(message = "Answer Cannot Be Null")
	private String correctAnswer; 
	
	
	
}
