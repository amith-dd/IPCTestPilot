package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Component
@Entity
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@NotBlank(message = "CourseName Cannot Be Blank")
	@NotNull(message = "CourseName Cannot Be Null")
	private String courseName;
	
	@ElementCollection
	private List<Integer> subjectIds;
	
	
	
	

}
