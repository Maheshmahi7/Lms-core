package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserDTO {
	
	private Integer id;
	private String registorNumber;
	private String name;
	private Integer roleId;
	private Integer departmentId;
	private String emailId;
	private String password;
	private String phone;
	private Integer isActive;

}
