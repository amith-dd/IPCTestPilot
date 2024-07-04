package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
import com.swaraj.IPCTestPilot.dto.Result;
=======
import com.swaraj.IPCTestPilot.entity.Result;
>>>>>>> 03026fed75378094f4a1c201109b2d2a8c5855fd

;
;

public interface ResultRepo extends JpaRepository<Result, Integer> {

	List<Result> findAllById(int studentId);

	@Query("SELECT q FROM Result q WHERE q.quizId = ?1")
	List<Result> findResultByQuizId(int quizId);

	@Query("SELECT s FROM Result s WHERE s.studentId = ?1")
	List<Result> findResultByStudentId(int studentId);

}
