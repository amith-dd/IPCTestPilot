package com.swaraj.IPCTestPilot.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.data.jpa.repository.Query;



import com.swaraj.IPCTestPilot.entity.Result;



public interface ResultRepo extends JpaRepository<Result, Integer> {

	List<Result> findAllById(int id);

//	@Query("SELECT q FROM Result q WHERE q.quizId = ?1")
//	List<Result> findResultByQuizId(int quizId);

//	@Query("SELECT s FROM Result s WHERE s.studentId = ?1")
//	List<Result> findResultByStudentId(int studentId);

}
