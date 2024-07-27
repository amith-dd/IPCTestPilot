package com.swaraj.IPCTestPilot.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Component
@Entity
@Data
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	
	@NotNull(message = "Subject ID cannot be null")
	@Min(value = 1, message = "Subject ID must be at least 1")
	@Max(value = 1000, message = "Subject ID must be at most 1000")
	private int subjectId;
	
	
	@NotNull(message = "Question cannot be null")
	@NotBlank(message = "Question cannot be blank")
	private String question;
	
	@NotNull(message = "Option A cannot be null")
	@NotBlank(message = "Option A cannot be blank")
	private String optionA;
	
	@NotNull(message = "Option B cannot be null")
	@NotBlank(message = "Option B cannot be blank")
	private String optionB;
	
	@NotNull(message = "Option C cannot be null")
	@NotBlank(message = "Option C cannot be blank")
	private String optionC;
	
	@NotNull(message = "Option D cannot be null")
	@NotBlank(message = "Option D cannot be blank")
	private String optionD;
	
	
	@NotNull(message = "Correct Answer cannot be null")
	@NotBlank(message = "Correct Answer cannot be blank")
	private String correctAnswer; 
	
	
	
}
