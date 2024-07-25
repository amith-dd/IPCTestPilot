package com.swaraj.IPCTestPilot.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	
	
		
}
