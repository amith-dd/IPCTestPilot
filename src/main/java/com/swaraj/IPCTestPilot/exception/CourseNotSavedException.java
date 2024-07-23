package com.swaraj.IPCTestPilot.exception;

public class CourseNotSavedException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public CourseNotSavedException(String message) {
		super();
		this.message = message;
	}
	
}
