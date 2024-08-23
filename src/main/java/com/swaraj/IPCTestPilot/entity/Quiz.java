package com.swaraj.IPCTestPilot.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;
	private int subjectId;
	@ElementCollection
	@JsonIgnore
	private List<Integer> questionIds; 
	
}
