package com.swaraj.IPCTestPilot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.IPCTestPilot.entity.Quiz;
import com.swaraj.IPCTestPilot.service.QuizService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService service;

	@PostMapping
	@Operation(summary = "Save Quiz Details")
	public ResponseEntity<ResponseStructure<Quiz>> saveQuiz(@RequestBody Quiz quiz) {
		return service.saveQuiz(quiz);
	}

	@GetMapping("findall")
	@Operation(summary = "Find All Quiz")
	public ResponseEntity<ResponseStructure<List<Quiz>>> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find Quiz By Quiz ID")
	public ResponseEntity<ResponseStructure<Quiz>> findQuiz(@PathVariable int quizId) {
		return service.findQuiz(quizId);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Quiz By Quiz ID")
	public ResponseEntity<ResponseStructure<Quiz>> deleteQuiz(@PathVariable int quizId) {
		return service.deleteQuiz(quizId);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update Quiz")
	public ResponseEntity<ResponseStructure<Quiz>> updateQuiz(@RequestBody Quiz quiz, @PathVariable int quizId) {
		return service.updateQuiz(quiz, quizId);
	}

	@PostMapping("createquiz")
	@Operation(summary = "Create A Quiz")
	public ResponseEntity<ResponseStructure<Quiz>> createQuiz(@RequestBody Map<String, Integer> input) {
		return service.createQuiz(input.get("subjectId"), input.get("numberOfquestions"));
	}

}
