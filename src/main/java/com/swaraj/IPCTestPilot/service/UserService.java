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
import com.swaraj.IPCTestPilot.exception.UserNotFoundException;
import com.swaraj.IPCTestPilot.exception.UserSaveFailedException;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import jakarta.transaction.Transactional;

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

            return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.CREATED);
        }
        throw new UserSaveFailedException("Failed to save user");
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

            return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
        }
        throw new UserNotFoundException("User not found with ID: " + userId);
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUser() {
        List<User> users = dao.findAllUser();
        if (users != null) {
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("All users retrieved");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure, HttpStatus.OK);
        }
        throw new UserNotFoundException("No users found");
    }
    @Transactional
    public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userId) {
        User user = dao.deleteUser(userId);
        if (user != null) {
            UserDto udto = new UserDto();
            mapper.map(user, udto);

            ResponseStructure<UserDto> structure = new ResponseStructure<>();
            structure.setData(udto);
            structure.setMessage("User deleted successfully");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
        }
        throw new UserNotFoundException("User not found with ID: " + userId);
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

            return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
        }
        throw new UserNotFoundException("User not found with ID: " + userId);
    }

    public ResponseEntity<ResponseStructure<Boolean>> verifyUser(String email, String password) {
        boolean isVerified = dao.verifyUser(email, password);
        if(isVerified) {
        ResponseStructure<Boolean> structure = new ResponseStructure<>();
        structure.setData(isVerified);
        structure.setMessage("User verified");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<ResponseStructure<Boolean>>(structure, HttpStatus.OK);
    }
        throw new UserNotFoundException("Invalid credentials");
        
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersByRole(int role) {
        List<User> users = dao.findUsersByRole(role);
        if (users == null || users.isEmpty()) {
            throw new UserNotFoundException("No users found for role: " + role);
        }
        else{
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("Users retrieved by role");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure, HttpStatus.OK);
        }
     
    }

    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersBySubjectId(int subjectId) {
        List<User> users = dao.findUsersBySubjectId(subjectId);
        if (users != null && !users.isEmpty()) {
        List<UserDto> userDtos = users.stream().map(user -> {
            UserDto udto = new UserDto();
            mapper.map(user, udto);
            return udto;
        }).collect(Collectors.toList());

        ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
        structure.setData(userDtos);
        structure.setMessage("Users retrieved by subject ID");
        structure.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure, HttpStatus.OK);
        }
        throw new UserNotFoundException("No users found for subject ID: " + subjectId);
    }
}
