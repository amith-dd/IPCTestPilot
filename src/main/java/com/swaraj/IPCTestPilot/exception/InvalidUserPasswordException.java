package com.swaraj.IPCTestPilot.exception;

public class InvalidUserPasswordException extends RuntimeException{

	 private String message;

	 
	 
	public InvalidUserPasswordException(String message) {
		
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	 
	 
}
