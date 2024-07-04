package com.swaraj.IPCTestPilot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.QuestionDao;
import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class QuestionService {

	@Autowired
	 QuestionDao dao;
	

    /**
     * Saves a question and returns a response entity with the saved question.
     *
     * @param question The question to save.
     * @return A response entity with the saved question.
     */
    public ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question) {
        Question savedQuestion = dao.saveQuestion(question);
        if (savedQuestion != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(savedQuestion);
            structure.setMessage("Question saved");
            structure.setStatus(HttpStatus.CREATED.value());

            return new ResponseEntity<>(structure, HttpStatus.CREATED);
        }
        return null;
//        throw new QuestionNotFoundException("Failed to save question");
    }

    /**
     * Finds a question by its ID and returns a response entity with the found question.
     *
     * @param questionId The ID of the question.
     * @return A response entity with the found question.
     */
    public ResponseEntity<ResponseStructure<Question>> findQuestion(int questionId) {
        Question question = dao.findQuestion(questionId);
        if (question != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(question);
            structure.setMessage("Question found");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
            
        }
        return null;
//        throw new QuestionNotFoundException("Question not found with ID: " + questionId);
    }

    /**
     * Deletes a question by its ID and returns a response entity with the deleted question.
     *
     * @param questionId The ID of the question to delete.
     * @return A response entity with the deleted question.
     */
    public ResponseEntity<ResponseStructure<Question>> deleteQuestion(int questionId) {
        Question question = dao.deleteQuestion(questionId);
        if (question != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(question);
            structure.setMessage("Question deleted");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
//        throw new QuestionNotFoundException("Question not found with ID: " + questionId);
    }

    /**
     * Updates an existing question by its ID and returns a response entity with the updated question.
     *
     * @param question The new question data.
     * @param questionId The ID of the question to update.
     * @return A response entity with the updated question.
     */
    public ResponseEntity<ResponseStructure<Question>> updateQuestion(Question question, int questionId) {
        Question updatedQuestion = dao.updateQuestion(question, questionId);
        if (updatedQuestion != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(updatedQuestion);
            structure.setMessage("Question updated");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
//        throw new QuestionNotFoundException("Question not found with ID: " + questionId);
    }

    /**
     * Retrieves a list of question IDs based on the subject ID and limits the number of results.
     *
     * @param subjectId The ID of the subject.
     * @param numberOfQuestions The maximum number of questions to retrieve.
     * @return A response entity with the list of question IDs.
     */
    public ResponseEntity<ResponseStructure<List<Integer>>> getQuestions(int subjectId, int numberOfQuestions) {
        List<Integer> questionIds = dao.getQuestions(subjectId, numberOfQuestions);
        if (questionIds != null && !questionIds.isEmpty()) {
            ResponseStructure<List<Integer>> structure = new ResponseStructure<>();
            structure.setData(questionIds);
            structure.setMessage("Questions retrieved");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
//        throw new QuestionNotFoundException("No questions found for subject ID: " + subjectId);
    }

    /**
     * Retrieves a list of questions based on their IDs and returns a response entity with the list of questions.
     *
     * @param questionIds The list of question IDs.
     * @return A response entity with the list of questions.
     */
    public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByQuestionId(List<Integer> questionIds) {
        List<Question> questions = dao.getQuestionsByQuestionId(questionIds);
        if (questions != null && !questions.isEmpty()) {
            ResponseStructure<List<Question>> structure = new ResponseStructure<>();
            structure.setData(questions);
            structure.setMessage("Questions retrieved");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
//        throw new QuestionNotFoundException("Questions not found for the provided IDs");
    }

}  
    
