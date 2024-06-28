package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.swaraj.IPCTestPilot.dto.Quiz;
import com.swaraj.IPCTestPilot.repo.QuizRepo;
@Repository 
public class QuizDao {
	@Autowired
	 QuizRepo quizRepo;
	public Quiz saveQuiz(Quiz quiz) {
		return quizRepo.save(quiz);
	} 
	
	public Quiz findQuiz(int quizId) {
		Optional<Quiz> opquiz = quizRepo.findById(quizId);
		if(opquiz.isPresent()) {
			return opquiz.get(); 
		}
		return null;
	}
	
	public Quiz deleteQuiz(int quizId) {
		Quiz quiz = findQuiz(quizId);
		if(quiz!=null) {
			quizRepo.delete(quiz);
			return quiz; 
		} 
		return null;
	}

	public Quiz updateQuiz(Quiz quiz, int quizId ) {
		Quiz dbquiz = findQuiz(quizId);
		if(dbquiz!=null) {
			quiz.setQuizId(quizId);
			return quizRepo.save(quiz);
		}
		return null;
	}
	
		public List < Quiz > findAll() {
       
			return quizRepo.findAll();
   
		}
	
	

}
