package com.swaraj.IPCTestPilot.exception;

public class UserSaveFailedException extends RuntimeException{
	
	private String message;

    public UserSaveFailedException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
