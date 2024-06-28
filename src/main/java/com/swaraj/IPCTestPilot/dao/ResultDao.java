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
	ResultRepo resultRepo;
	
	public Result saveResult(Result result) {
		return resultRepo.save(result);
	}
	
	public Result findResult(int studentId) {
		Optional<Result> opresult = resultRepo.findById(studentId);
		if(opresult.isPresent()) {
			return opresult.get();
		}
		return null;
	}
	
	public Result deleteResult(int studentId) {
		Result result = findResult(studentId);
		if(result!=null) {
			resultRepo.delete(result);
			return result;
		}
		return null;
	}
	
	public List<Result> findAll()
	{
		return resultRepo.findAll();
	}
	
	public List<Result> findAllById(int studentId)
	{
		List<Result> list=resultRepo.findAllById(studentId);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

}
