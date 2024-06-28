package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
//import com.boot.spring.demospringproject.dto.UserEntity;
=======
>>>>>>> 2d2a4e1d0a18b77552d433ea14c96b3c565a551e
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
}
