package com.swaraj.IPCTestPilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.swaraj.IPCTestPilot.dao.QuizDao;
import com.swaraj.IPCTestPilot.entity.Quiz;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

/**
 * Service class of {@link Quiz}
 * 
 * @author Anjali
 */
@Service
public class QuizService {

	@Autowired
	private QuizDao dao;

	/**
	 * This method uses {@link QuizDao} to save the {@link Quiz} entity to database
	 * 
	 * @param quiz - {@link Quiz}
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if saved
	 *         successfully
	 * 
	 */
	public ResponseEntity<ResponseStructure<Quiz>> saveQuiz(final Quiz quiz) {
		final Quiz savedQuiz = dao.saveQuiz(quiz);
		final ResponseStructure<Quiz> structure = new ResponseStructure<Quiz>();
		HttpStatus httpStatus = null;
		String message = null;
		if (savedQuiz != null) {
			message = "Quiz saved";
			httpStatus = HttpStatus.CREATED;
		} else {
			message = "Unable to save Quiz";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(savedQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Quiz>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link QuizDao} to find the {@link Quiz} entity by Id from
	 * database
	 * 
	 * @param quizId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found
	 *         successfully
	 */
	public ResponseEntity<ResponseStructure<Quiz>> findQuiz(final int quizId) {
		final Quiz findQuiz = dao.findQuiz(quizId);
		final ResponseStructure<Quiz> structure = new ResponseStructure<Quiz>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findQuiz != null) {
			message = "Quiz found";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Not Found";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(findQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Quiz>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link QuizDao} to delete the {@link Quiz} entity by Id from
	 * database
	 * 
	 * @param quizId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if deleted
	 *         successfully
	 */
	public ResponseEntity<ResponseStructure<Quiz>> deleteQuiz(final int quizId) {
		final Quiz deleteQuiz = dao.deleteQuiz(quizId);
		final ResponseStructure<Quiz> structure = new ResponseStructure<Quiz>();
		HttpStatus httpStatus = null;
		String message = null;
		if (deleteQuiz != null) {
			message = "Quiz deleted";
			httpStatus = HttpStatus.ACCEPTED;
		} else {
			message = "Unable to delete Quiz";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(deleteQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Quiz>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link QuizDao} to update the {@link Quiz} entity based on
	 * Id to database
	 * 
	 * @param quiz
	 * @param quizId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if updated
	 *         successfully
	 */
	public ResponseEntity<ResponseStructure<Quiz>> updateQuiz(final Quiz quiz, final int quizId) {
		final Quiz updateQuiz = dao.updateQuiz(quiz, quizId);
		final ResponseStructure<Quiz> structure = new ResponseStructure<Quiz>();
		HttpStatus httpStatus = null;
		String message = null;
		if (updateQuiz != null) {
			message = "Quiz updated";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Unable to update Quiz";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(updateQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Quiz>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link QuizDao} to find list of the {@link Quiz} entity from
	 * database
	 * 
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found all
	 *         quiz successfully
	 */
	public ResponseEntity<ResponseStructure<List<Quiz>>> findAll() {
		final List<Quiz> findAllquiz = dao.findAll();
		final ResponseStructure<List<Quiz>> structure = new ResponseStructure<List<Quiz>>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findAllquiz != null) {
			message = "All quiz found";
			httpStatus = HttpStatus.ACCEPTED;
		} else {
			message = "Unable to find AllQuiz";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(findAllquiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<List<Quiz>>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link QuizDao} to stores {@link Quiz} entity to database
	 * 
	 * @param subject
	 * @param numberofQuestions
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if created
	 *         successfully
	 */
	public ResponseEntity<ResponseStructure<Quiz>> createQuiz(final int subject, final int numberofQuestions) {
		final Quiz createdQuiz = dao.createQuiz(subject, numberofQuestions);
		final ResponseStructure<Quiz> structure = new ResponseStructure<Quiz>();
		HttpStatus httpStatus = null;
		String message = null;
		if (createdQuiz != null) {
			message = "Created";
			httpStatus = HttpStatus.CREATED;
		} else {
			message = "Unable to create Quiz";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		structure.setData(createdQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Quiz>>(structure, httpStatus);
	}

}
