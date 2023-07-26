package com.tirupathi.taskOfSpringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data                                                 // This is for to reduce set,get methods & others which are automatically provided by Lombok
//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor                                   // This is like default constructor

@Entity                                              // By this annotation SB will identify according to this class the table will be created
@Table(name = "users",                              // This is for our customized name otherwise table will create as Class name  (optional)
uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}) })   // We accept only unique email ids, no duplicates.We can do for any variable
                                                  
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)               // We can give our customized name for column otherwise it will take as below variable
	private String name;                                   // We don't want column with null when we want to store any data
	
	@Column(name = "email", nullable = false)              // We can write according to our requirement (optional)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;

}
