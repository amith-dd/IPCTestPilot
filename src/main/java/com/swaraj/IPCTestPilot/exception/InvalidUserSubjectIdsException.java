package com.swaraj.IPCTestPilot.exception;

public class InvalidUserSubjectIdsException extends RuntimeException{

	 private String message;

	 
	 
	public InvalidUserSubjectIdsException(String message) {
		
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	 
	 
}
