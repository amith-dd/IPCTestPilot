package com.swaraj.IPCTestPilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.QuestionDao;
import com.swaraj.IPCTestPilot.dao.QuizDao;
import com.swaraj.IPCTestPilot.dao.ResponseDao;
import com.swaraj.IPCTestPilot.dao.ResultDao;
import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.entity.Quiz;
import com.swaraj.IPCTestPilot.entity.Response;
import com.swaraj.IPCTestPilot.entity.Result;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class ResponseService {

	@Autowired
	ResponseDao dao;

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	@Autowired
	ResponseDao resulDao;

	@Autowired
	QuizDao qdao;

	@Autowired
	ResultDao rsDao;

	// save response

	public ResponseEntity<ResponseStructure<Response>> saveResponse(Response response) {

		ResponseStructure<Response> structure = new ResponseStructure<Response>();

		List<Question> questions = qdao.getQuestionsByQuizId(response.getQuizId());
		int marks = 0;
		for (Question q : questions) {
			if (q.getCorrectAnswer().equals(response.getAnswers().get(questions.indexOf(q)))) {
				marks++;
			}
		}

		Result rs = new Result();
		rs.setMarks(marks);
		rs.setQuizId(response.getQuizId());
		rs.setStudentId(response.getStudentId());

		rsDao.saveResult(rs);

		response.setMark(marks);

		structure.setData(resulDao.saveResponse(response));
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("response accepted");

		return new ResponseEntity<ResponseStructure<Response>>(structure, HttpStatus.OK);

	}

	// get response by response id

	public ResponseEntity<ResponseStructure<Response>> findResponseById(int responseId) {

		ResponseStructure<Response> structure = new ResponseStructure<Response>();
		Response existResponse = dao.findRessponseById(responseId);

		if (existResponse != null) {

			structure.setData(existResponse);
			structure.setMessage("Response saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Response>>(structure, HttpStatus.OK);
		} else
			return null;

	}

	// get all response

	public ResponseEntity<ResponseStructure<List<Response>>> getAllResponse() {

		ResponseStructure<List<Response>> structure = new ResponseStructure<List<Response>>();
		List<Response> existResponses = dao.getAllRespose();

		if (existResponses != null) {

			structure.setData(existResponses);
			structure.setMessage("The responses got successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Response>>>(structure, HttpStatus.OK);
		} else
			return null;
	}

	// result generator

//	public Response resultGenerator(Response response){

//	    response.setMark(markGenerator(response));
//	    Response updatedResponse =  dao.updateResponse(response, response.getResponseId());
	// result intialization
//		resulDao.saveResponse(response);

//		if(updatedResponse != null) {
//			
//			return updatedResponse;
//		}
//		else return null;
}

// mark generator

//	public int markGenerator(Response response) {
//			
////		List<Integer> questions = quizDao.findQuiz(response.getQuizId()).getQuestionIds();
////		List<Integer> correctlyAnsweredQuestion = questions.stream().filter(qid->questionDao.findQuestion(qid).getCorrectAnswer().equals(response.getAnswers())).toList();
//		return correctlyAnsweredQuestion.size();
//	}
//}
