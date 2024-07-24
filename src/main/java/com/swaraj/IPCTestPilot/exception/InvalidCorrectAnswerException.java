package com.swaraj.IPCTestPilot.exception;

public class InvalidCorrectAnswerException extends RuntimeException{
	
	

	private String message;

    public InvalidCorrectAnswerException(String message) {
        this.message=message ;
    }
    public String getMessage() {
        return message;
    }

}
