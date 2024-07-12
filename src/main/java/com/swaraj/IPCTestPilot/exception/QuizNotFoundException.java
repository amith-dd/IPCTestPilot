package com.swaraj.IPCTestPilot.exception;

public class QuizNotFoundException extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public QuizNotFoundException(String message) {
		this.message = message;
	}
}
 