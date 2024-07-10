package com.swaraj.IPCTestPilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.swaraj.IPCTestPilot.dto.UserDto;
import com.swaraj.IPCTestPilot.entity.User;
import com.swaraj.IPCTestPilot.service.UserService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseStructure<UserDto>> signupUser(@RequestBody User user) {
        return userService.singupUser(user);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UserDto>> findUser(@PathVariable int userId) {
        return userService.findUser(userId);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers() {
        return userService.findAllUser();
    }

    @DeleteMapping
    public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user, @PathVariable int userId) {
        return userService.updateUser(user, userId);
    }

    @PostMapping("/verify")
    public ResponseEntity<ResponseStructure<Boolean>> verifyUser(@RequestParam String email, @RequestParam String password) {
        return userService.verifyUser(email, password);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersByRole(@PathVariable int role) {
        return userService.findUsersByRole(role);
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersBySubjectId(@PathVariable int subjectId) {
        return userService.findUsersBySubjectId(subjectId);
    }
}
