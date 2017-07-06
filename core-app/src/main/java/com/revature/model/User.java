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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@Table(name="user")
@JsonInclude(Include.NON_NULL)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Column(name="REGISTER_NUMBER", unique=true)
	private String registerNumber;
	@NotNull
	private String name;
	@NotNull
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;
	@NotNull
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	@NotNull
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;
	@NotNull
	private String password;
	@NotNull
	@Column(unique = true, name="PHONE_NUMBER")
	private String phone;
	@NotNull
	@ManyToOne
	@JoinColumn(name="IS_ACTIVE")
	private Status isActive; 


}
