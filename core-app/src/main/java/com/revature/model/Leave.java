package com.revature.model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

@Data
@Entity
@Table(name="leaves")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	@NotNull
	@ManyToOne
	@JoinColumn(name="LEAVE_ID")
	private LeaveType leaveType;
	@Column(name="NO_OF_DAYS_REQUIRED")
	private Integer noOfDaysRequired;
	@NotNull
	@Generated(GenerationTime.ALWAYS) 
	@Column(name="APPLIED_DATE",insertable=false,updatable=false)
	@Temporal(TemporalType.DATE)
	private Date appliedDate;
	@NotNull
	@Column(name="FROM_DATE")
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@NotNull
	@Column(name="TO_DATE")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@NotNull
	@ManyToOne
	@JoinColumn(name="STATUS")
	private Status isActive; 
	
	

}
