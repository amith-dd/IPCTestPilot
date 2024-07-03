package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.repo.QuestionRepo;

@Repository
public class QuestionDao {



    @Autowired
    private QuestionRepo repo;



    public Question saveQuestion(Question question) {
        return repo.save(question);
    }

    public Question findQuestion(int questionId) {
    	Optional<Question> opQuestion=repo.findById(questionId);
		if(opQuestion.isPresent()) {
			return opQuestion.get();
			}
		return null;
		}


    public List<Question> findAllQuestions(int subjectid) {
        return repo.findAll();
    }

    public Question deleteQuestion(int questionId) {
        Question question = findQuestion(questionId);
        if (question != null) {
        	repo.delete(question);
            return question;
        }
        return null;
    }

    public Question updateQuestion(Question question, int questionId) {
        Question dbQuestion = findQuestion(questionId);
        if (dbQuestion != null) {
            question.setQuestionId(questionId);
            return repo.save(question);
        }
        return null;
    }
    

    public List<Integer> getQuestions(int subjectId, int numberOfQuestions) {
        return repo.findQuestionIdsBySubjectId(subjectId, numberOfQuestions);
    }

    
    public List<Question> getQuestionsByQuestionId(List<Integer> questionIds) {
        return repo.findAllById(questionIds);
    }

    
    
}
