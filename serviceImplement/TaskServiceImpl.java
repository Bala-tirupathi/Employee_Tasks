package com.tirupathi.taskOfSpringboot.serviceImplement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirupathi.taskOfSpringboot.entity.Task;
import com.tirupathi.taskOfSpringboot.entity.Users;
import com.tirupathi.taskOfSpringboot.exception.TaskAccessException;
import com.tirupathi.taskOfSpringboot.exception.TaskNotFound;
import com.tirupathi.taskOfSpringboot.exception.UserNotFound;
import com.tirupathi.taskOfSpringboot.payloadDto.TaskDto;
import com.tirupathi.taskOfSpringboot.repository.TaskRepository;
import com.tirupathi.taskOfSpringboot.repository.UserRepository;
import com.tirupathi.taskOfSpringboot.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private ModelMapper modelMapper;                    //**It is taken from java default main class check it once what is use of this mapper**
	
	@Autowired
	private UserRepository userRepository;             // we need to checking user is there or not thats why this is autowired here
	
	@Autowired
	private TaskRepository taskRepository;             // To store task data

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		//findById will checks the user,gives true if user presents otherwise it will give false
		Users user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound(String.format("User Id %d is not found", userId))) ;
		Task task = modelMapper.map(taskDto, Task.class);   //Here by using model mapper internally converted task dto to task class entity
		task.setUsers(user);                               // After setting the user we are storing the data in db
		Task savedTask = taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);  //Here by using model mapper internally converted task class entity to task dto 
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		Users user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound(String.format("User Id %d is not found", userId))) ;
		
		List<Task> tasks = taskRepository.findAllByUsersId(userId);
		return tasks.stream().map(task -> modelMapper.map(tasks, TaskDto.class)).collect(Collectors.toList());
		// Here we are doing List task is converted into list of taskDto by using (Collectors.toList())
	}

	@Override
	public TaskDto getTask(long userId, long taskId) {
		Users user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound(String.format("User Id %d is not found", userId))) ;
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFound(String.format("Task Id %d is not found", taskId)));
		
		/* User can access respective tasks only, for example user id 1 can access his tasks only but not user id 2 tasks,
		   for this we need write check if thats task is belongs that respective user id or not like as below */
		if(user.getId() != task.getUsers().getId()) {
			throw new TaskAccessException(String.format("Task id %d is not belongs to user id %d", taskId, userId));
		}
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTask(long userId, long taskId) {         // Here void is return type bc that deleted task don't go for saving process
		Users user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound(String.format("User Id %d is not found", userId))) ;
		
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFound(String.format("Task Id %d is not found", taskId)));
		
		if(user.getId() != task.getUsers().getId()) {
			throw new TaskAccessException(String.format("Task id %d is not belongs to user id %d", taskId, userId));
		}
		taskRepository.deleteById(taskId);;
	}

}

   /* Streams are used to map one object to another object in the collection */
/* Model mapper main use to avoid the convertion process of Dto to entity and vice versa*/