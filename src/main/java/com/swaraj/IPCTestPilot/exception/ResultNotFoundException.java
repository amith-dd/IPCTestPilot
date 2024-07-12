package com.swaraj.IPCTestPilot.exception;

public class ResultNotFoundException extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public ResultNotFoundException(String message) {
		this.message = message;
	}
}
