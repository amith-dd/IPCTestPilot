package com.swaraj.IPCTestPilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
	
	@ExceptionHandler(QuestionSaveFailedException.class)
    public ResponseEntity<String> handleQuestionSaveFailedException(QuestionSaveFailedException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<String> handleQuestionNotFoundException(QuestionNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(UserSaveFailedException.class)
    public ResponseEntity<String> handleUserSaveFailedException(UserSaveFailedException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } 
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }	

}
