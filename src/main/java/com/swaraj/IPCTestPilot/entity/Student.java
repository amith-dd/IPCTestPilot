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

@Data
@Entity
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@NotBlank(message = "Student Name Cannot Be Blank")
	@NotNull(message = "Student Name Cannot Be Null")
	private String studentName;
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message = "Student Email Cannot Be Blank")
	@NotNull(message = "Student Email Cannot Be Null")
	private String studentEmail;
	
	@Positive
	@Min(value = 6000000000l,message = "Contact Should be Greater than 6000000000")
	@Max(value = 9999999999l,message = "Contact should be Less than 9999999999")
	private long studentContact;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,20}$", 
			message = "Password Must contain Atleast 1 Number, 1 Lower Case and 1 Upper Case Alphabets, 1 Special Character , Minimum of 8 Characters and Maximum of 20 Characters")
	@NotBlank(message = "Password Cannot Be Blank")
	@NotNull(message = "Password Cannot Be Null")
	private String studentPassword;
	
	@Positive(message = "Student Course Id cannot be Negative")
	private int studentCourseId;
	
	@ElementCollection
	private List<Integer> studentResultIds;
	

	
	
}
