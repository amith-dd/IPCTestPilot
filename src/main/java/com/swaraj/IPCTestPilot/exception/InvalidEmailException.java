package com.swaraj.IPCTestPilot.exception;

public class InvalidEmailException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public InvalidEmailException(String message) {
		this.message = message;
	}
	
	
	
}
