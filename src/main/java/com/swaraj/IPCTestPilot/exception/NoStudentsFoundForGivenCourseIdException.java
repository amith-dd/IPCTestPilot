package com.swaraj.IPCTestPilot.exception;

public class NoStudentsFoundForGivenCourseIdException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public NoStudentsFoundForGivenCourseIdException(String message) {
		this.message = message;
	}
	
}
