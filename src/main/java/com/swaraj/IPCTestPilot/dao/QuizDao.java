package com.swaraj.IPCTestPilot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.entity.Quiz;
import com.swaraj.IPCTestPilot.repo.QuizRepo;

/**
 * DAO class of {@link Quiz}
 * 
 * @author Anjali
 * 
 */
@Repository
public class QuizDao {
	@Autowired
	QuizRepo quizRepo;
	@Autowired
	QuestionDao questionDao;

	/**
	 * This
	 * @param quiz
	 * @return
	 */ 
	public Quiz saveQuiz(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	/**
	 * @param quizId
	 * @return
	 */
	public Quiz findQuiz(int quizId) {
		Optional<Quiz> opquiz = quizRepo.findById(quizId);
		if (opquiz.isPresent()) {
			return opquiz.get();
		}
		return null;
	}

	/**
	 * @param quizId
	 * @return
	 */
	public Quiz deleteQuiz(int quizId) {
		Quiz quiz = findQuiz(quizId);
		if (quiz != null) {
			quizRepo.delete(quiz);
			return quiz;
		}
		return null;
	}

	/**
	 * @param quiz
	 * @param quizId
	 * @return
	 */
	public Quiz updateQuiz(Quiz quiz, int quizId) {
		Quiz dbquiz = findQuiz(quizId);
		if (dbquiz != null) {
//			quiz.setQuizId(quizId);
			return quizRepo.save(quiz);
		}
		return null;
	}

	/**
	 * @return
	 */
	public List<Quiz> findAll() {
		return quizRepo.findAll();
	}                                                         

	/**
	 * @param subject
	 * @param numofQuestions
	 * @return 
	 */
	public Quiz createQuiz(int subjectId, int numofQuestions) {
		List<Integer> l = questionDao.getQuestions(subjectId, numofQuestions);
		Quiz quiz = new Quiz();
		quiz.setQuestionIds(l);
		return quizRepo.save(quiz);
	}

	public List<Question> getQuestionsByQuizId(int quizId){
		List<Question> questions = new ArrayList<Question>();
		Optional<Quiz> opquiz = quizRepo.findById(quizId);
		if(opquiz.isPresent()) {
			for(Integer i : opquiz.get().getQuestionIds()) {
				questions.add(questionDao.findQuestion(i));
			}
		}
		return questions;
	}
	
	
}
