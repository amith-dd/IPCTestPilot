package com.swaraj.IPCTestPilot.exception;

public class QuestionNotFoundException extends RuntimeException{
	
	private String message;

    public QuestionNotFoundException(String message) {
        this.message=message ;
    }
    public String getMessage() {
        return message;
    }

}
