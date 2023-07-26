package com.tirupathi.taskOfSpringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{      // This exception we will manually in the TaskServiceimpl
	private String message;
	
	public UserNotFound(String message) {
		super(message);                        // This message will showed in output by RuntimeException if user is not found
		this.message = message;               
	}

}


		/* We need to handle exception otherwise execution will stop abnormally, Example we have only two users in our data base 
		   But we assigned a task to the user 3 by mistake then in console that will tell use User Id 3 is not found as message */
		 