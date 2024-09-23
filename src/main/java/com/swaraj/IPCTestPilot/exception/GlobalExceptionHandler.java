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
	public ResponseEntity<ResponseStructure<String>> handleQuestionSaveFailedException(QuestionSaveFailedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Question save failed");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleQuestionNotFoundException(QuestionNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("question not found with the given ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(UserSaveFailedException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserSaveFailedException(UserSaveFailedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("user save failed");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


//
//
//    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
//        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    } 
//	
	@ExceptionHandler(InvalidSubjectIdException.class)
    public ResponseEntity<String> handleInvalidSubjectIdException(InvalidSubjectIdException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("user not found with the given ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleCourseNotFoundException(CourseNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("course not found with the given ID");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourseNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> handleCourseNotSavedException(CourseNotSavedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("course not saved");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectPasswordExeption.class)
	public ResponseEntity<ResponseStructure<String>> handleIncorrectPasswordExeption(IncorrectPasswordExeption ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("incorrect password");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidEmailException(InvalidEmailException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("invalid email");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoStudentsFoundForGivenCourseIdException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoStudentsFoundForGivenCourseIdException(
			NoStudentsFoundForGivenCourseIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("no students found for given course id");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StudentNotFoundWithGivenIdException.class)
	public ResponseEntity<ResponseStructure<String>> handleStudentNotFoundWithGivenIdException(StudentNotFoundWithGivenIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("no student exist with the given ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StudentNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> handleStudentNotFoundWithGivenIdException(StudentNotSavedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("student could not be saved");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResultNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleResultNotFoundException(ResultNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("result not found with the given ID");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(ResultNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> handleResultNotSavedException(ResultNotSavedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("result save failed");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(QuizNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleQuizNotFoundException(QuizNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Quiz not found with the given ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(QuizNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> handleQuizNotSavedException(QuizNotSavedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Quiz save failed");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


}
