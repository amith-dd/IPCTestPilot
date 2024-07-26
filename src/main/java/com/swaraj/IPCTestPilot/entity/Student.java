package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentContact;
	private String studentPassword;
	private int studentCourseId;
	@ElementCollection
	private List<Integer> studentResultIds;
	

	
	
}
