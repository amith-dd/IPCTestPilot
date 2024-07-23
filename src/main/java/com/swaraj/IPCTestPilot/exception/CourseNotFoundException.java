package com.swaraj.IPCTestPilot.exception;

public class CourseNotFoundException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public CourseNotFoundException(String message) {
		this.message = message;
	}


	
}
