package com.swaraj.IPCTestPilot.dto;

import java.util.List;

import lombok.Data;



@Data
public class UserDto {
	
	private int userId;
	private String userName;
	private String userEmail;
	private List<Integer> userSubjectIds;
	
	
	
	
}
