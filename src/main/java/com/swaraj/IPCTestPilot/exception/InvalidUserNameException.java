package com.swaraj.IPCTestPilot.exception;

public class InvalidUserNameException extends RuntimeException{

	 private String message;

	 
	 
	public InvalidUserNameException(String message) {
		
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	 
	 
}
