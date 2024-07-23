package com.swaraj.IPCTestPilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.IPCTestPilot.entity.Result;
import com.swaraj.IPCTestPilot.service.ResultService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("result")
public class ResultController {
	@Autowired
	ResultService service;
	
	@PostMapping
	@Operation(summary = "Save Result")
	public ResponseEntity<ResponseStructure<Result>> saveResult(@RequestBody Result result){
		return service.saveResult(result);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find a Result By Result ID")
	public ResponseEntity<ResponseStructure<Result>> findResult(@PathVariable int resultId){
		return service.findResult(resultId);
	}
	
	@GetMapping("getall")
	@Operation(summary = "Get All Results")
	public ResponseEntity<ResponseStructure<List<Result>>> findAll(){
		return service.findAll();
	}
	
	@GetMapping("resultbyquizid/{id}")
	@Operation(summary = "Find Result List by Quiz Id")
	public ResponseEntity<ResponseStructure<List<Result>>> findResultByQuizId(@RequestParam int QuizId){
		return service.findResultByQuizId(QuizId);
	}

	@GetMapping("resultbystudentid/{id}")
	@Operation(summary = "Find List Of Result For Student By Student ID")
	public ResponseEntity<ResponseStructure<List<Result>>> findResultByStudentId(@RequestParam int StudentId){
		return service.findResultByStudentId(StudentId);
	}
	
}
