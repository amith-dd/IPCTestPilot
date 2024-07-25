package com.swaraj.IPCTestPilot.dto;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class QuestionDto {
=======
import lombok.Data;
>>>>>>> 3830d1248b1d334d966cea85bdc510c64daecbfe

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
