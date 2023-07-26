package com.tirupathi.taskOfSpringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TaskAccessException extends RuntimeException{  //If User1 wants to access user2 tasks or vice-versa then we need to throw an exception
	private String message;
	
	public TaskAccessException(String message) {
		super(message);
		this.message = message;
	}

}
