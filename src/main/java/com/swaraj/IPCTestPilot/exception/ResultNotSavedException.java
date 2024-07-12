package com.swaraj.IPCTestPilot.exception;

public class ResultNotSavedException extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public ResultNotSavedException(String message) {
		super();
		this.message = message;
	}
}
