package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Component
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "User Name Cannot Be Blank")
	@NotNull(message = "User Name Cannot Be Null")
	private String userName;
	
	@Positive
	@Min(value = 6000000000l,message = "Contact Should be Greater than 6000000000")
	@Max(value = 9999999999l,message = "Contact should be Less than 9999999999")
	private long userContact;
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message = "Email Cannot Be Blank")
	@NotNull(message = "Email Cannot Be Null")
	private String userEmail;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,20}$", 
			message = "Password Must contain Atleast 1 Number, 1 Lower Case and 1 Upper Case Alphabets, 1 Special Character , Minimum of 8 Characters and Maximum of 20 Characters")
	@NotBlank(message = "Password Cannot Be Blank")
	@NotNull(message = "Password Cannot Be Null")
	private String userPassword;
	
	@Positive(message = "Role Must be a Positive Number")
	private int userRole;
	
//	@ElementCollection
//	private List<Integer> userSubjectIds;

	
	
	
	
	
	
}
