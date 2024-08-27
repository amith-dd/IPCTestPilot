package com.swaraj.IPCTestPilot.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.QuestionDao;
import com.swaraj.IPCTestPilot.dto.QuestionDto;
import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.exception.QuestionNotFoundException;
import com.swaraj.IPCTestPilot.exception.QuestionSaveFailedException;
import com.swaraj.IPCTestPilot.repo.QuestionRepo;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class QuestionService {

	@Autowired
	QuestionDao dao;

	@Autowired
	private QuestionRepo repo;


	@Autowired
	ModelMapper mapper;


	/**
	 * Saves a question and returns a response entity with the saved question DTO.
	 *
	 * @param question The question to save.
	 * @return A response entity with the saved question DTO.
	 */
	public ResponseEntity<ResponseStructure<QuestionDto>> saveQuestion(Question question) {
		Question savedQuestion = dao.saveQuestion(question);
		if (savedQuestion != null) {

			QuestionDto qdto = mapper.map(savedQuestion, QuestionDto.class);

			ResponseStructure<QuestionDto> structure = new ResponseStructure<>();
			structure.setData(qdto);
			structure.setMessage("Question saved");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<QuestionDto>>(structure, HttpStatus.CREATED);
		}

		throw new QuestionSaveFailedException("Failed to save question");
	}

	/**
	 * Finds a question by its ID and returns a response entity with the found
	 * question DTO.
	 *
	 * @param questionId The ID of the question.
	 * @return A response entity with the found question DTO.
	 */
	public ResponseEntity<ResponseStructure<QuestionDto>> findQuestion(int questionId) {
		Question question = dao.findQuestion(questionId);
		if (question != null) {
			QuestionDto qdto = new QuestionDto();
			mapper.map(question, qdto);
			ResponseStructure<QuestionDto> structure = new ResponseStructure<>();
			structure.setData(qdto);
			structure.setMessage("Question found");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<QuestionDto>>(structure, HttpStatus.OK);
		}

		throw new QuestionNotFoundException("Question not found with ID: " + questionId);
	}

	/**
	 * Deletes a question by its ID and returns a response entity with the deleted
	 * question DTO.
	 *
	 * @param questionId The ID of the question to delete.
	 * @return A response entity with the deleted question DTO.
	 */
	public ResponseEntity<ResponseStructure<QuestionDto>> deleteQuestion(int questionId) {
		Question question = dao.deleteQuestion(questionId);
		if (question != null) {
			QuestionDto qdto = new QuestionDto();
			mapper.map(question, qdto);
			ResponseStructure<QuestionDto> structure = new ResponseStructure<>();
			structure.setData(qdto);
			structure.setMessage("Question deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<QuestionDto>>(structure, HttpStatus.OK);
		}
		throw new QuestionNotFoundException("Question not found with ID: " + questionId);
	}

	/**
	 * Updates an existing question by its ID and returns a response entity with the
	 * updated question DTO.
	 *
	 * @param question   The new question data.
	 * @param questionId The ID of the question to update.
	 * @return A response entity with the updated question DTO.
	 */
	public ResponseEntity<ResponseStructure<QuestionDto>> updateQuestion(Question question, int questionId) {
		Question updatedQuestion = dao.updateQuestion(question, questionId);
		if (updatedQuestion != null) {
			QuestionDto qdto = new QuestionDto();
			mapper.map(updatedQuestion, qdto);
			ResponseStructure<QuestionDto> structure = new ResponseStructure<>();
			structure.setData(qdto);
			structure.setMessage("Question updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<QuestionDto>>(structure, HttpStatus.OK);
		}

		throw new QuestionNotFoundException("Question not found with ID: " + questionId);
	}

	/**
	 * Retrieves a list of question IDs based on the subject ID and limits the
	 * number of results.
	 *
	 * @param subjectId         The ID of the subject.
	 * @param numberOfQuestions The maximum number of questions to retrieve.
	 * @return A response entity with the list of question IDs.
	 */
//    public List<Integer> getQuestions(int subjectId, int numberOfQuestions) {
//        return repo.findQuestionIdsBySubject(subjectId, numberOfQuestions);
//    }
	public ResponseEntity<ResponseStructure<List<Integer>>> getQuestions(int subjectId, int numberOfQuestions) {
		List<Integer> questionIds = dao.getQuestions(subjectId, numberOfQuestions);

		if (questionIds != null && !questionIds.isEmpty()) {
			ResponseStructure<List<Integer>> structure = new ResponseStructure<>();
			structure.setData(questionIds);
			structure.setMessage("Questions retrieved");
			structure.setStatus(HttpStatus.OK.value());

			return ResponseEntity.ok(structure);
		}

		throw new QuestionNotFoundException("No questions found for subject ID: " + subjectId);

	}

	/**
	 * Retrieves a list of questions based on their IDs and returns a response
	 * entity with the list of question DTOs.
	 *
	 * @param questionIds The list of question IDs.
	 * @return A response entity with the list of question DTOs.
	 */
	public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsByQuestionId(List<Integer> questionIds) {
		List<Question> questions = dao.getQuestionsByQuestionId(questionIds);
		if (questions != null && !questions.isEmpty()) {
			List<QuestionDto> questionDtos = questions.stream().map(q -> {
				QuestionDto qdto = new QuestionDto();
				mapper.map(q, qdto);
				return qdto;
			}).toList();

			ResponseStructure<List<QuestionDto>> structure = new ResponseStructure<>();
			structure.setData(questionDtos);
			structure.setMessage("Questions retrieved");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<List<QuestionDto>>>(structure, HttpStatus.OK);
		}

		throw new QuestionNotFoundException("Questions not found for the provided IDs");
	}

	public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsBySubId( int subjectId) {
   	 List<Question> questions = dao.getQuestionBySubId(subjectId);

        if (questions != null ) {
            ResponseStructure<List<QuestionDto>> structure = new ResponseStructure<>();
            List<QuestionDto> qdtos = questions.stream().map(q -> {
            										QuestionDto dto = new QuestionDto();
            										mapper.map(q, dto);
            										return dto;
            										}).toList();
            structure.setData(qdtos);
            structure.setMessage("Questions retrieved");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<List<QuestionDto>>>(structure,HttpStatus.OK);
        }

        throw new QuestionNotFoundException("No questions found for subject ID: " + subjectId);
     
      
   }

}
