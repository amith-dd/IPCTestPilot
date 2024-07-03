package com.swaraj.IPCTestPilot.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.UserDao;
import com.swaraj.IPCTestPilot.dto.UserDto;
import com.swaraj.IPCTestPilot.entity.User;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	@Autowired
	ModelMapper mapper;

	public ResponseEntity<ResponseStructure<UserDto>> singupUser(User user) {
		User singupUser = dao.singupUser(user);
		if (singupUser != null) {
			
			
			UserDto udto =  new UserDto();
			mapper.map(singupUser,udto);
			
			ResponseStructure<UserDto> structure = new ResponseStructure<>();
			structure.setData(udto);
			structure.setMessage("User Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.CREATED);
		}
		return null;
	}
}
