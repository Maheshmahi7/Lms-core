package com.revature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LeaveTypeDTO {
	private Integer id;
	private String name;
	private Integer noOfDays;
	private Integer isActive;


}
