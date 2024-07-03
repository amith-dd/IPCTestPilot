package com.swaraj.IPCTestPilot.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
public class UserDto {
	
	private int userId;
	private String userName;
	private String userEmail;
	private List<Integer> userCourseIds;
	
	
	
	
}
