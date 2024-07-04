package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swaraj.IPCTestPilot.entity.Result;
;

public interface ResultRepo extends JpaRepository<Result, Integer> {

	List<Result> findAllById(int studentId);

	@Query("SELECT r FROM Result r WHERE r.quizId = ?1")
	List<Result> findResultByQuizId(int quizId);

	/**
	 * unimplemented method for future reference
	 */
	List<Result> findResultByStudentId(int studentId);

}
