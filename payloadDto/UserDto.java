package com.tirupathi.taskOfSpringboot.payloadDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	private long id;
	private String name;
	private String email;
	private String password;

}

/* DTO is Data transfer object used to transfer or receiving data, to save Users we can store the data of all parameters of Users like in json 
   by using Entity class is not a good practice. Then that json data is assigned to users variable [ex:- (@Requestbody Users users)]
   in controller method. In many projects they have additional configurations like in our project @ManyToOne here user_id from the Users table-
   only internally. Here we don't want to interrupt Entity class so we will go with DTO class.
  
  Actual process:- After creating this DTO class the details we can get from the Users then that details we can move into entity class. So -
  there is no interruption for that Entity.   */

