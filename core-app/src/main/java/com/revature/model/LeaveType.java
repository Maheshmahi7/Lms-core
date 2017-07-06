package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="leave_type")
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Column(unique=true)
	private String name;
	@NotNull
	@Column(name="NO_OF_DAYS")
	private Integer noOfDays;
	@NotNull
	@ManyToOne
	@JoinColumn(name="IS_ACTIVE")
	private Status isActive; 

}
