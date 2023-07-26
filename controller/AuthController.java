package com.tirupathi.taskOfSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirupathi.taskOfSpringboot.entity.Users;
import com.tirupathi.taskOfSpringboot.payloadDto.UserDto;
import com.tirupathi.taskOfSpringboot.service.UserService;

@RestController
@RequestMapping("/api/auth")                                       // This is optional, it will map this controller when "/api/auth" api will come
public class AuthController {
	
	@Autowired
	private UserService userService;                              // We want to use UserService methods that why taken this reference
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {//@RequestBody is for taking json data from Users, users is a reference(container)
		//userService.createUser(userDto);                 //By using save method here data in refer users will store in db through repository
		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

}

/*  In the implementation we converted userDto into users entity object because we have only UserRepository not UserDtoRepository
 *  so that we can stored in db by using user again that stored data is converted into DTO to show users
 *  By using this ResponseEntity<UserDto> return type in the place of void we can show the data */

 