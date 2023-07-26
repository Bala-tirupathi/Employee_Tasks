package com.tirupathi.taskOfSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirupathi.taskOfSpringboot.payloadDto.TaskDto;
import com.tirupathi.taskOfSpringboot.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//Creating a task
    @PostMapping("/{userId}/tasks")                                                                                      
	public ResponseEntity<TaskDto> saveTask(@PathVariable (name = "userId") long userId, @RequestBody TaskDto taskDto){
		return new ResponseEntity<> (taskService.saveTask(userId, taskDto), HttpStatus.CREATED );
	}
    
    //Get all tasks
    @GetMapping("/{userId}/tasks")  //Below name "userId" is for mapping path data{userId} and long userId variable for using inside our content
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable (name = "userId") long userId ) {
    	return new ResponseEntity<> (taskService.getAllTasks(userId), HttpStatus.OK);  //If we forgot List at 33 line we will get error here
    }
    
    //Get individual task by Id
    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable (name ="userId" ) long userId,
    		@PathVariable (name = "taskId") long taskId){
    	return new ResponseEntity<TaskDto> (taskService.getTask(userId, taskId), HttpStatus.OK);
    }
    
    //Delete individual task
    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable (name ="userId" ) long userId,           // return type String here in ResponseEntity
    		@PathVariable (name = "taskId") long taskId){
    	taskService.deleteTask(userId, taskId);
    	return new ResponseEntity<> ("Task deleted Successfully", HttpStatus.OK);
    }

}