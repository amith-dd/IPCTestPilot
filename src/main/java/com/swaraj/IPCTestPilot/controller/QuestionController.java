package com.swaraj.IPCTestPilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.IPCTestPilot.dto.QuestionDto;
import com.swaraj.IPCTestPilot.entity.Question;
import com.swaraj.IPCTestPilot.service.QuestionService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	
	
	@Autowired
    private QuestionService questionService;

    @PostMapping
    @Operation(summary = "Save a Question")
    public ResponseEntity<ResponseStructure<QuestionDto>> saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Question by ID")
    public ResponseEntity<ResponseStructure<QuestionDto>> findQuestion(@PathVariable int id) {
        return questionService.findQuestion(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Question by ID")
    public ResponseEntity<ResponseStructure<QuestionDto>> deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Question by ID")
    public ResponseEntity<ResponseStructure<QuestionDto>> updateQuestion(@RequestBody Question question, @PathVariable int id) {
        return questionService.updateQuestion(question, id);
    }

    @GetMapping("/subject/{subjectId}")
    @Operation(summary = "Get List of Questions By Subject ID")
    public ResponseEntity<ResponseStructure<List<Integer>>> getQuestions(@PathVariable int subjectId, @RequestParam int numberOfQuestions) {
        return questionService.getQuestions(subjectId, numberOfQuestions);
    }

    @PostMapping("/byIds")
    @Operation(summary = "Find Multiple Questions By Question ID's")
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuestionsByQuestionId(@RequestBody List<Integer> questionIds) {
        return questionService.getQuestionsByQuestionId(questionIds);
    }
}
	
	
	
	
	
	
	
	


