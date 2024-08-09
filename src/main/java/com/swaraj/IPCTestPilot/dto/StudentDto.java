package com.swaraj.IPCTestPilot.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class StudentDto {
	
	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentContact;
	private int studentCourseId;
	
}
