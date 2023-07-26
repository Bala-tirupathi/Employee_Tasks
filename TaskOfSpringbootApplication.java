package com.tirupathi.taskOfSpringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskOfSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskOfSpringbootApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {              // This is for avoid converting dto to entity and vice-versa
		return new ModelMapper();
	}

}
