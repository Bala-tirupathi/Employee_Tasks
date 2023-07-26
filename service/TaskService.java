package com.tirupathi.taskOfSpringboot.service;

import java.util.List;

import com.tirupathi.taskOfSpringboot.payloadDto.TaskDto;

public interface TaskService {
	
	public TaskDto saveTask(long userId, TaskDto taskDto);   // we should implement this two method in taskserviceimpl class
	
	public List<TaskDto> getAllTasks(long userId);           // getting all tasks by using Id and stored as list in TaskDto
	
	public TaskDto getTask(long userId, long taskId);        // For Getting individual task by taskId with respective userId
	
	public void deleteTask(long userId, long taskId);        // Here void is return type bc that deleted task don't go for saving process

}
