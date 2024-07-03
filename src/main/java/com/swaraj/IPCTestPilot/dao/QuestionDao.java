package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.dto.Question;
import com.swaraj.IPCTestPilot.repo.QuestionRepo;

@Repository
public class QuestionDao {


    @Autowired
    private QuestionRepo questionRepo;


    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

    public Question findQuestion(int questionId) {
    	Optional<Question> opQuestion=questionRepo.findById(questionId);
		if(opQuestion.isPresent()) {
			return opQuestion.get();
			}
		return null;
		}


    public List<Question> findAllQuestions(int subjectid) {
        return questionRepo.findAll();
    }


    public Question deleteQuestion(int questionId) {
        Question question = findQuestion(questionId);
        if (question != null) {
        	questionRepo.delete(question);
            return question;
        }
        return null;
    }

    public Question updateQuestion(Question question, int questionId) {
        Question dbQuestion = findQuestion(questionId);
        if (dbQuestion != null) {
            question.setQuestionId(questionId);
            return questionRepo.save(question);
        }
        return null;
    }
    
    public List<Integer> getQuestions(String subject, int numberOfQuestions) {
        return questionRepo.findQuestionIdsBySubject(subject, numberOfQuestions);
    }
    
    public List<Question> getQuestionsByQuestionId(List<Integer> questionIds) {
        return questionRepo.findAllById(questionIds);
    }

    
    
}
