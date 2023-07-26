package com.tirupathi.taskOfSpringboot.payloadDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
	
	private long id;    
	private String taskname;
	
}

/*Observe difference b/w Task entity and Task dto classes no need with user id variable bc all users data in json gained internally*/