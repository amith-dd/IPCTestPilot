package com.swaraj.IPCTestPilot.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.UserDao;
import com.swaraj.IPCTestPilot.dto.User;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public ResponseEntity<ResponseStructure<User>> singupUser(User user) {
		User singupUser = dao.singupUser(user);
		if (singupUser != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(singupUser);
			structure.setMessage("User Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
		}
		return null;
	}
}
