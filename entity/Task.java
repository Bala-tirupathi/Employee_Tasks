package com.tirupathi.taskOfSpringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "taskname", nullable = false)
	private String taskname;
	
	@ManyToOne(fetch = FetchType.LAZY)                     //We can use this annotation when We want to assign many task to one user
	@JoinColumn(name = "users_id")                        //For joining user table with this task table by using user id                                                    
	private Users users;                                 //individual user data from Users table taken as an Object by using userid (foreign key) 

	

}
