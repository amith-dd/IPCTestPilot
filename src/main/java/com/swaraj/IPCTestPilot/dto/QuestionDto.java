package com.swaraj.IPCTestPilot.dto;

import lombok.Setter;

public class QuestionDto {
	
	@Setter
	private int subjectId;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;

}
