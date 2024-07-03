package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Response;
import com.swaraj.IPCTestPilot.repo.ResponseRepo;

@Repository
public class ResponseDao {
	
	@Autowired
    ResponseRepo repo;
	
	//save response
	
	public Response saveResponse(Response response) {
		
		Response existResponse = repo.save(response);
		if(existResponse != null) {

			return existResponse;
		}
		else return null;
	}
	
	//get response
	
	public Response findRessponseById(int responseId) {
		
		Optional<Response> opt = repo.findById(responseId);
		
		if(opt.isPresent()) {
			
			return opt.get();
		}
		else return null;
		
	}
	
	//List of response
	
	public List<Response> getAllRespose(){
		
		List<Response> existResponses = repo.findAll();
		
		if(existResponses != null) {
			
			return existResponses;
		}
		else return null;
		
	}
	
	//update Response
	
	public Response updateResponse(Response response, int responseId) {
		
		Response existResponse = findRessponseById(responseId);
		
		if(existResponse != null) {
			
			response.setResponseId(existResponse.getResponseId());
			Response updateResponse = repo.save(response);
			return updateResponse;
		}
		else return null;
	}
	
}
