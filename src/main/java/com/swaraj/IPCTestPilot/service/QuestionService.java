package com.swaraj.IPCTestPilot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.swaraj.IPCTestPilot.dao.QuestionDao;
import com.swaraj.IPCTestPilot.dto.Course;
import com.swaraj.IPCTestPilot.dto.Question;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class QuestionService {

	@Autowired
	 QuestionDao dao;
	
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
    }

    public ResponseEntity<ResponseStructure<Question>> findQuestion(int questionId) {
        Question question = dao.findQuestion(questionId);
        if (question != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(question);
            structure.setMessage("Question found");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        ResponseStructure<Question> structure = new ResponseStructure<>();
        structure.setMessage("Question not found");
        structure.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseStructure<Question>> deleteQuestion(int questionId) {
        Question question = dao.deleteQuestion(questionId);
        if (question != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(question);
            structure.setMessage("Question deleted");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        ResponseStructure<Question> structure = new ResponseStructure<>();
        structure.setMessage("Question not found");
        structure.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseStructure<Question>> updateQuestion(Question question, int questionId) {
        Question updatedQuestion = dao.updateQuestion(question, questionId);
        if (updatedQuestion != null) {
            ResponseStructure<Question> structure = new ResponseStructure<>();
            structure.setData(updatedQuestion);
            structure.setMessage("Question updated");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        ResponseStructure<Question> structure = new ResponseStructure<>();
        structure.setMessage("Question not found");
        structure.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseStructure<List<Integer>>> getQuestions(String subject, int numberOfQuestions) {
        List<Integer> questionIds = dao.getQuestions(subject, numberOfQuestions);
        ResponseStructure<List<Integer>> structure = new ResponseStructure<>();
        structure.setData(questionIds);
        structure.setMessage("Questions retrieved");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByQuestionId(List<Integer> questionIds) {
        List<Question> questions = dao.getQuestionsByQuestionId(questionIds);
        ResponseStructure<List<Question>> structure = new ResponseStructure<>();
        structure.setData(questions);
        structure.setMessage("Questions retrieved");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
}  
    
