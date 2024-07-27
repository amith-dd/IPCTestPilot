package com.swaraj.IPCTestPilot.exception;

public class InvalidUserContactException extends RuntimeException{

	public String message;

	public InvalidUserContactException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
