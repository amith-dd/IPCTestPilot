package com.swaraj.IPCTestPilot.exception;

public class InvalidSubjectIdException extends RuntimeException{
	
	private String message;

    public InvalidSubjectIdException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
