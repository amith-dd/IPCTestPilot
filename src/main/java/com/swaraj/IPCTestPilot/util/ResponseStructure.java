package com.swaraj.IPCTestPilot.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
<<<<<<< HEAD
@JsonInclude(Include.NON_NULL)
=======
@Getter
@Setter
>>>>>>> 3830d1248b1d334d966cea85bdc510c64daecbfe
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
		
}
