package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.dto.Result;
import com.swaraj.IPCTestPilot.repo.ResultRepo;
@Repository
public class ResultDao {
	@Autowired
	ResultRepo repo;
	
	public Result saveResult(Result result) {
		return repo.save(result);
	}
	
	public Result findResult(int studentId) {
		Optional<Result> opresult =repo.findById(studentId);
		if(opresult.isPresent()) {
			return opresult.get();
		}
		return null;
	}
	
	public Result deleteResult(int studentId) {
		Result result = findResult(studentId);
		if(result!=null) {
			repo.delete(result);
			return result;
		}
		return null;
	}
	
	public List<Result> findAll()
	{
		return repo.findAll();
	}
	
	public List<Result> findAllById(int studentId)
	{
		List<Result> list=repo.findAllById(studentId);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

}
