package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.dto.Question;
@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT q.questionId FROM Question q WHERE q.subject = :subject ORcDER BY q.questionId ASC LIMIT :limit", nativeQuery = true)
    List<Integer> findQuestionIdsBySubject(@Param("subject") String subject, @Param("limit") int limit);
}
	
	


