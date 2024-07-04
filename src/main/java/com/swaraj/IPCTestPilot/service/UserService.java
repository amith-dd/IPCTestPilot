package com.swaraj.IPCTestPilot.service;

import java.util.List;
import java.util.stream.Collectors;

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
    private UserDao dao;
    
    @Autowired
    private ModelMapper mapper;

    public ResponseEntity<ResponseStructure<UserDto>> singupUser(User user) {
        User singupUser = dao.singupUser(user);
        if (singupUser != null) {
            UserDto udto = new UserDto();
            mapper.map(singupUser, udto);


            ResponseStructure<UserDto> structure = new ResponseStructure<>();
            structure.setData(udto);
            structure.setMessage("User saved successfully");
            structure.setStatus(HttpStatus.CREATED.value());

            return new ResponseEntity<>(structure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<UserDto>> findUser(int userId) {
        User user = dao.findUser(userId);
        if (user != null) {
            UserDto udto = new UserDto();
            mapper.map(user, udto);

            ResponseStructure<UserDto> structure = new ResponseStructure<>();
            structure.setData(udto);
            structure.setMessage("User found");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUser() {
        List<User> users = dao.findAllUser();
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("All users retrieved");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userId) {
        User user = dao.deleteUser(userId);
        if (user != null) {
            UserDto udto = new UserDto();
            mapper.map(user, udto);

            ResponseStructure<UserDto> structure = new ResponseStructure<>();
            structure.setData(udto);
            structure.setMessage("User deleted successfully");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user, int userId) {
        User updatedUser = dao.updateUser(user, userId);
        if (updatedUser != null) {
            UserDto udto = new UserDto();
            mapper.map(updatedUser, udto);

            ResponseStructure<UserDto> structure = new ResponseStructure<>();
            structure.setData(udto);
            structure.setMessage("User updated successfully");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<Boolean>> verifyUser(String email, String password) {
        boolean isVerified = dao.verifyUser(email, password);
        ResponseStructure<Boolean> structure = new ResponseStructure<>();
        structure.setData(isVerified);
        structure.setMessage(isVerified ? "User verified" : "Invalid credentials");
        structure.setStatus(isVerified ? HttpStatus.OK.value() : HttpStatus.UNAUTHORIZED.value());

        return new ResponseEntity<>(structure, isVerified ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersByRole(int role) {
        List<User> users = dao.findUsersByRole(role);
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("Users retrieved by role");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersBySubjectId(int subjectId) {
        List<User> users = dao.findUsersBySubjectId(subjectId);
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("Users retrieved by subject ID");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

	
	
	

}
