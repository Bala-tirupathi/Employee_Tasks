package com.tirupathi.taskOfSpringboot.service;

import com.tirupathi.taskOfSpringboot.payloadDto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);              //When we stored the data in UserDto with userDto reference So here return is UserDto
		                                                    // Created User stored in UserDto thats why we changed void to UserDto

}
