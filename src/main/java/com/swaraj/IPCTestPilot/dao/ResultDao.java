package com.swaraj.IPCTestPilot.dao;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.dto.Result;
import com.swaraj.IPCTestPilot.repo.ResultRepo;

/**
 * DAO class of {@link Result}
 * 
 * @author Ajay
 * 
 */
@Repository
public class ResultDao {
	@Autowired
	ResultRepo repo;

	/**
	 * @param result
	 * @return Result
	 */
	public Result saveResult(Result result) {
		return repo.save(result);
	}

	/**
	 * @param studentId
	 * @return Result
	 */
	public Result findResult(int resultId) {
		Optional<Result> opresult = repo.findById(resultId);
		if (opresult.isPresent()) {
			return opresult.get();
		}
		return null;
	}

	/**
	 * @param
	 * @return list of Result
	 */
	public List<Result> findAll() {
		return repo.findAll();
	}

	/**
	 * @param resultId
	 * @return list of result
	 */
	public List<Result> findAllById(int resultId) {
		List<Result> list = repo.findAllById(resultId);
		if (list != null) {
			return list;
		}
		return null;
	}

	/**
	 * @param quizId
	 * @return list of Result's
	 */
	public List<Result> findResultByQuizId(int quizId) {
		List<Result> list = repo.findResultByQuizId(quizId);
		if (list != null) {
			return list;
		}
		return null;
	}

	/**
	 * @param studentId
	 * @return list of Result's
	 */
	public List<Result> findResultByStudentId(int studentId) {
		return repo.findResultByStudentId(studentId);
	}

}
