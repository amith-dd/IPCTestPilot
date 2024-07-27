package com.swaraj.IPCTestPilot.exception;

public class InvalidUserRoleException extends RuntimeException{

	 private String message;

	 
	 
	public InvalidUserRoleException(String message) {
		
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	 
	 
}
