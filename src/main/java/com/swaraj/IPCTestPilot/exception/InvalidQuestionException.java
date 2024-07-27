package com.swaraj.IPCTestPilot.exception;

public class InvalidQuestionException extends RuntimeException {
	
	
	
	private String message;

    public InvalidQuestionException(String message) {
        this.message=message ;
    }
    public String getMessage() {
        return message;
    }


}
