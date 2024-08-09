package com.swaraj.IPCTestPilot.exception;

public class QuizNotSavedException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}
  
	public QuizNotSavedException(String message) {
		super();
		this.message = message;
	}
}
