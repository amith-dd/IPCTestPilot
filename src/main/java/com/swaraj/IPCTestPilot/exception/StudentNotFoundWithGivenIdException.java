package com.swaraj.IPCTestPilot.exception;

public class StudentNotFoundWithGivenIdException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotFoundWithGivenIdException(String message) {
		this.message = message;
	}
	
	
	
}
