package com.swaraj.IPCTestPilot.exception;

public class QuestionSaveFailedException extends RuntimeException {

	private String message;
	
	public QuestionSaveFailedException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
