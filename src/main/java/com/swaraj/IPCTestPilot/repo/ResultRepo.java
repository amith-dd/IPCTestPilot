package com.swaraj.IPCTestPilot.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Result;


@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {


	List<Result> findByresultId(int id);

//	List<Result> findAllById(int id);


//	@Query("SELECT q FROM Result q WHERE q.quizId = ?1")
//	List<Result> findResultByQuizId(int quizId);

	List<Result> findBystudentId(int studentId);

}
