package com.revature.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LeaveDTO {
	private Integer id;
	private String userId;
	private Integer leaveId;
	private Integer noOfDaysRequired;
	private Date appliedDate;
	private Date fromDate;
	private Date toDate;
	private Integer status;


}
