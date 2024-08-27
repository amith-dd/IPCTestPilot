package com.swaraj.IPCTestPilot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.swaraj.IPCTestPilot.dao.ResultDao;
import com.swaraj.IPCTestPilot.entity.Result;
import com.swaraj.IPCTestPilot.exception.ResultNotFoundException;
import com.swaraj.IPCTestPilot.exception.ResultNotSavedException;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

/**
 * Service class of {@link Result}
 * 
 * @author Ajay
 */
@Service
public class ResultService {
	@Autowired
	private ResultDao dao;

	/**
	 * This method uses {@link ResultDao} to save the {@link Result} entity to
	 * database
	 * 
	 * @param Result - {@link Result}
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if saved
	 *         successfully or else null
	 * 
	 */
	public ResponseEntity<ResponseStructure<Result>> saveResult(Result result) {
		final Result savedResult = dao.saveResult(result);
		final ResponseStructure<Result> structure = new ResponseStructure<Result>();
		HttpStatus httpStatus = null;
		String message = null;
		if (savedResult != null) {
			message = "Result saved";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Unable to save Result";
			throw new ResultNotSavedException(message);
		}
		httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		structure.setData(savedResult);
		structure.setMessage(message);
		structure.setStatus(HttpStatus.CREATED.value());// gives the
												// code
		return new ResponseEntity<ResponseStructure<Result>>(structure, httpStatus);

	}

	/**
	 * This method uses {@link ResultDao} to find the {@link Result} entity by Id
	 * from database
	 * 
	 * @param resultId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found
	 *         successfully or else null
	 */
	public ResponseEntity<ResponseStructure<Result>> findResult(int resultId) {
		final Result findResult = dao.findResult(resultId);
		final ResponseStructure<Result> structure = new ResponseStructure<Result>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findResult != null) {
			message = "Result found";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Result Not Found";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			throw new ResultNotFoundException(message);
		}
		structure.setData(findResult);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<Result>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link ResultDao} to find list of the {@link Result} entity
	 * from database
	 * 
	 * @param
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found all
	 *         Result successfully or else null
	 */
	public ResponseEntity<ResponseStructure<List<Result>>> findAll() {
		final List<Result> findAllResult = dao.findAll();
		final ResponseStructure<List<Result>> structure = new ResponseStructure<List<Result>>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findAllResult != null) {
			message = "All Result found";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Unable to find AllResult";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			throw new ResultNotFoundException(message);
		}
		structure.setData(findAllResult);
		structure.setMessage(message);
		structure.setStatus(HttpStatus.ACCEPTED.value());// gives the code
		return new ResponseEntity<ResponseStructure<List<Result>>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link ResultDao} to find list of the {@link Result} list of
	 * Quiz from database
	 * 
	 * @param QuizId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found all
	 *         QuizId successfully or else null
	 */
	public ResponseEntity<ResponseStructure<List<Result>>> findResultByQuizId(int QuizId) {
		final List<Result> findQuiz = dao.findResultByQuizId(QuizId);
		final ResponseStructure<List<Result>> structure = new ResponseStructure<List<Result>>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findQuiz != null) {
			message = "QuizId's found";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Unable to find QuizId's";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			throw new ResultNotFoundException(message);
		}
		structure.setData(findQuiz);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<List<Result>>>(structure, httpStatus);
	}

	/**
	 * This method uses {@link ResultDao} to find list of the {@link Result} List of
	 * Students from database
	 * 
	 * @param StudentId
	 * @return {@link ResponseEntity} of type {@link ResponseStructure} if found all
	 *         StudentId successfully or else null
	 */
	public ResponseEntity<ResponseStructure<List<Result>>> findResultByStudentId(int StudentId) {
		final List<Result> findStudent = dao.findResultByStudentId(StudentId);
		final ResponseStructure<List<Result>> structure = new ResponseStructure<List<Result>>();
		HttpStatus httpStatus = null;
		String message = null;
		if (findStudent != null) {
			message = "StudentId's found";
			httpStatus = HttpStatus.OK;
		} else {
			message = "Unable to find StudentId's";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			throw new ResultNotFoundException(message);
		}
		structure.setData(findStudent);
		structure.setMessage(message);
		structure.setStatus(httpStatus.value());// gives the code
		return new ResponseEntity<ResponseStructure<List<Result>>>(structure, httpStatus);
	}
}
