package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message = "User name cannot be null")
	@NotBlank(message = "User name cannot be blank")
	@Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
	private String userName;
	
	@NotNull(message = "User contact cannot be null")
	@Min(value = 1000000000L, message = "User contact must be at least 10 digits")
	private long userContact;
	
	@NotNull(message = "User email cannot be null")
	@NotBlank(message = "User email cannot be blank")
	@Email(message = "User email must be a valid email address")
	private String userEmail;
	
	@NotNull(message = "User password cannot be null")
	@NotBlank(message = "User password cannot be blank")
	@Size(min = 4, message = "User password must be at least 4 characters")
	private String userPassword;
	
	@NotNull(message = "User role cannot be null")
	private int userRole;
	
	@ElementCollection
	@NotNull(message = "User subject IDs cannot be null")
	private List<Integer> userSubjectIds;
}
