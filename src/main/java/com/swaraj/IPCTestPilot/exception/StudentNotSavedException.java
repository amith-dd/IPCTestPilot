package com.swaraj.IPCTestPilot.exception;

public class StudentNotSavedException extends RuntimeException{

	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotSavedException(String message) {
		this.message = message;
	}
	
	
	
}	
