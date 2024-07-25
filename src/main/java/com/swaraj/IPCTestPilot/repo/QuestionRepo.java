package com.swaraj.IPCTestPilot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;







import com.swaraj.IPCTestPilot.entity.Question;

@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {


    @Query(value = "SELECT q.question_Id FROM Question q WHERE q.subject_id = :subjectId ORDER BY q.question_Id ASC LIMIT :limit", nativeQuery = true)
    List<Integer> findQuestionIdsBySubject(@Param("subjectId") int subjectId, @Param("limit") int limit);

	/**
     * Finds a list of question IDs based on the subject ID and limits the number of results randomly.
     *
     * @param subjectId The ID of the subject.
     * @param limit The maximum number of questions to retrieve.
     * @return A list of question IDs.
     */
    @Query("SELECT q FROM Question q WHERE q.questionId IN :questionIds")
    List<Question> findAllByQuestionIdIn(@Param("questionIds") List<Integer> questionIds);

}

   
