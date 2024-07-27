package com.swaraj.IPCTestPilot.exception;

public class InvalidUserEmailException extends RuntimeException{

	public String message;

	public InvalidUserEmailException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
