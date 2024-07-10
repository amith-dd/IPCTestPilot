package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;







import com.swaraj.IPCTestPilot.entity.Question;

@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {


	@Query("SELECT q.id FROM Question q WHERE q.subjectId = :subjectId ORDER BY RAND() LIMIT :numberOfQuestions")
    List<Integer> findQuestionIdsBySubjectId(int subjectId, int numberOfQuestions);
	
	 List<Question> findAllById(List<Integer> questionIds);
}

   
