package com.tirupathi.taskOfSpringboot.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirupathi.taskOfSpringboot.entity.Users;
import com.tirupathi.taskOfSpringboot.payloadDto.UserDto;
import com.tirupathi.taskOfSpringboot.repository.UserRepository;
import com.tirupathi.taskOfSpringboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired                                           // If this @Autowired annotation is  not provided then userRepository gives null values
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
    //userDto is not an Entity of Users,for save method we need to type-caste userDto to Users by using below methods- 
		//userRepository.save(userDto);                                // b/c unable to use  userDto or users directly
		Users user = userDtoToEntity(userDto);
		Users savedUsers = userRepository.save(user);                 // Again Users is need to convert into Dto b/c return type is UserDto
		return entityToUserDto(savedUsers);                          // Here we need write converted entity class into dto
	}
	
	private Users userDtoToEntity(UserDto userDto) {                   // Here dto is converted into Entity
		Users users = new Users();
		users.setEmail(userDto.getEmail());                           // No need to send ID in Dto
		users.setName(userDto.getName());                            // Getting data from userDto and stored that into Users Entity reference
		users.setPassword(userDto.getPassword());

		return users;
		
	}
	
	private UserDto entityToUserDto(Users savedUsers) {
		UserDto userDto = new UserDto();
		userDto.setId(savedUsers.getId());                        //Here ID is required bc in return savedUsers we will have that ID
		userDto.setEmail(savedUsers.getEmail());
		userDto.setName(savedUsers.getName());
		userDto.setPassword(savedUsers.getPassword());

		return userDto;
	}

}
