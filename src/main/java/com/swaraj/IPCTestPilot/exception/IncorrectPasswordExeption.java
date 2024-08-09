package com.swaraj.IPCTestPilot.exception;

public class IncorrectPasswordExeption extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public IncorrectPasswordExeption(String message) {
		this.message = message;
	}
	
	
	
}
