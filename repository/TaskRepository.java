package com.tirupathi.taskOfSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tirupathi.taskOfSpringboot.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userId);                          // This useful at TaskServiceimpl class

}
