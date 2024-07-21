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


	@ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(CourseNotSavedException.class)
    public ResponseEntity<String> handleCourseNotSavedException(CourseNotSavedException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(IncorrectPasswordExeption.class)
    public ResponseEntity<String> handleIncorrectPasswordExeption(IncorrectPasswordExeption ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<String> handleInvalidEmailException(InvalidEmailException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NoStudentsFoundForGivenCourseIdException.class)
    public ResponseEntity<String> handleNoStudentsFoundForGivenCourseIdException(NoStudentsFoundForGivenCourseIdException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(StudentNotFoundWithGivenIdException.class)
    public ResponseEntity<String> handleStudentNotFoundWithGivenIdException(StudentNotFoundWithGivenIdException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(StudentNotSavedException.class)
    public ResponseEntity<String> handleStudentNotFoundWithGivenIdException(StudentNotSavedException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<String> handleResultNotFoundException(ResultNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(ResultNotSavedException.class)
    public ResponseEntity<String> handleResultNotSavedException(ResultNotSavedException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


	@ExceptionHandler(QuizNotFoundException.class)
    public ResponseEntity<String> handleQuizNotFoundException(QuizNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
	 
	@ExceptionHandler(QuizNotSavedException.class)
    public ResponseEntity<String> handleQuizNotSavedException(QuizNotSavedException ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }


}
