package com.swaraj.IPCTestPilot.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {


<<<<<<< HEAD
    @Query(value = "SELECT q.question_Id FROM Question q WHERE q.subject_id = :subjectId ORDER BY q.question_Id ASC LIMIT :limit", nativeQuery = true)
    List<Integer> findQuestionIdsBySubject(@Param("subjectId") int subjectId, @Param("limit") int limit);

	/**
=======
	@Query(value = "SELECT q.question_id FROM Question q WHERE q.subject_id = :subjectId ORDER BY q.question_id ASC LIMIT :limit", nativeQuery = true)
	List<Integer> findQuestionIdsBySubject(@Param("subjectId") int subjectId, @Param("limit") int limit);
/**
>>>>>>> 3830d1248b1d334d966cea85bdc510c64daecbfe
     * Finds a list of question IDs based on the subject ID and limits the number of results randomly.
     *
     * @param subjectId The ID of the subject.
     * @param limit The maximum number of questions to retrieve.
     * @return A list of question IDs.
     */
<<<<<<< HEAD
    @Query("SELECT q FROM Question q WHERE q.questionId IN :questionIds")
    List<Question> findAllByQuestionIdIn(@Param("questionIds") List<Integer> questionIds);

=======
	 @Query("SELECT q FROM Question q WHERE q.questionId IN :questionIds")
	  List<Question> findAllByQuestionIdIn(@Param("questionIds") List<Integer> questionIds);
>>>>>>> 3830d1248b1d334d966cea85bdc510c64daecbfe
}

   
