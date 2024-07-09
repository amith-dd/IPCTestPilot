package com.swaraj.IPCTestPilot.dto;

import lombok.Data;
import lombok.Setter;
@Data
public class QuestionDto {

	private int subjectId;
	private String questionContent;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	
}
