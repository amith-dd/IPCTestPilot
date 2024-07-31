package com.swaraj.IPCTestPilot.dto;

import lombok.Data;

@Data
public class QuestionDto {
    
	private int questionId;
	private int subjectId;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	
}