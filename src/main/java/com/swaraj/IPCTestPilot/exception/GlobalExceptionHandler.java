package com.swaraj.IPCTestPilot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swaraj.IPCTestPilot.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice

public class GlobalExceptionHandler {
	
	@ExceptionHandler
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {

		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String, String> hash = new HashMap<String, String>();

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hash.put(field, message);
		}
		structure.setMessage("add proper details");
		structure.setData(hash);
		structure.setStatus(HttpStatus.FORBIDDEN.value());

		return new ResponseEntity<Object>(structure, HttpStatus.FORBIDDEN);
	}


    @ExceptionHandler(InvalidQuestionException.class)
    public ResponseEntity<String> handleInvalidQuestionException(InvalidQuestionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOptionException.class)
    public ResponseEntity<String> handleInvalidOptionException(InvalidOptionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCorrectAnswerException.class)
    public ResponseEntity<String> handleInvalidCorrectAnswerException(InvalidCorrectAnswerException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }



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
	
	@ExceptionHandler(InvalidSubjectIdException.class)
    public ResponseEntity<String> handleInvalidSubjectIdException(InvalidSubjectIdException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourseNotSavedException.class)
	public ResponseEntity<String> handleCourseNotSavedException(CourseNotSavedException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IncorrectPasswordExeption.class)
	public ResponseEntity<String> handleIncorrectPasswordExeption(IncorrectPasswordExeption ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<String> handleInvalidEmailException(InvalidEmailException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoStudentsFoundForGivenCourseIdException.class)
	public ResponseEntity<String> handleNoStudentsFoundForGivenCourseIdException(
			NoStudentsFoundForGivenCourseIdException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(StudentNotFoundWithGivenIdException.class)
	public ResponseEntity<String> handleStudentNotFoundWithGivenIdException(StudentNotFoundWithGivenIdException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(StudentNotSavedException.class)
	public ResponseEntity<String> handleStudentNotFoundWithGivenIdException(StudentNotSavedException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResultNotFoundException.class)

	public ResponseEntity<String> handleResultNotFoundException(ResultNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(ResultNotSavedException.class)
	public ResponseEntity<String> handleResultNotSavedException(ResultNotSavedException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(QuizNotFoundException.class)
	public ResponseEntity<String> handleQuizNotFoundException(QuizNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(QuizNotSavedException.class)
	public ResponseEntity<String> handleQuizNotSavedException(QuizNotSavedException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}


}
