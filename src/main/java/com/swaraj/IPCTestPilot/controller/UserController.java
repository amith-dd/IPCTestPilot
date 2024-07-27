package com.swaraj.IPCTestPilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.swaraj.IPCTestPilot.dto.UserDto;
import com.swaraj.IPCTestPilot.entity.User;
import com.swaraj.IPCTestPilot.service.UserService;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(summary = "Signup User")
    public ResponseEntity<ResponseStructure<UserDto>> signupUser(@RequestBody User user) {
        return userService.signupUser(user);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Find User by User ID")
    public ResponseEntity<ResponseStructure<UserDto>> findUser(@PathVariable int userId) {
        return userService.findUser(userId);
    }

    @GetMapping
    @Operation(summary = "Find All Users")
    public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers() {
        return userService.findAllUser();
    }

	@DeleteMapping("/{userId}")
    @Operation(summary = "Delete User By User ID")
    public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping
    @Operation(summary = "Update User Details")
    public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user, @RequestParam int userId) {
        return userService.updateUser(user, userId);
    }


    @PostMapping("/verify")
    @Operation(summary = "Verify User Details")
    public ResponseEntity<ResponseStructure<Boolean>> verifyUser(@RequestParam String email, @RequestParam String password) {
        return userService.verifyUser(email, password);
    }

    @GetMapping("/role/{role}")
    @Operation(summary = "Find Users By Role")
    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersByRole(@PathVariable int role) {
        return userService.findUsersByRole(role);
    }

    @GetMapping("/subject/{subjectId}")
    @Operation(summary = "Find Users By Subject")
    public ResponseEntity<ResponseStructure<List<UserDto>>> findUsersBySubjectId(@PathVariable int subjectId) {
        return userService.findUsersBySubjectId(subjectId);
    }
}
