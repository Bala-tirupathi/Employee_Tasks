package com.tirupathi.taskOfSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tirupathi.taskOfSpringboot.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> { 
	
	/*<T, Id > Users entity for knowing which repository this belongs & date type is Long which is Id.
	 *  Now by using JpaRepository (which is having sorting and all others methods) reference, we can create all crud operations
	 *  in the controller class but directly creating crud operations in controller class is may not be good practice.
	 *  So here Service classes will come to picture and all business logic we can write in the service class
	 */

}
