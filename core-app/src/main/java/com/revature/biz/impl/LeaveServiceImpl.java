package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.LeaveService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.LeaveDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Leave;
import com.revature.model.LeaveType;
import com.revature.model.User;
import com.revature.model.dto.LeaveDTO;

@Service
public class LeaveServiceImpl implements LeaveService{
	private static Logger logger=Logger.getLogger(LeaveServiceImpl.class);

	@Autowired
	private LeaveDAO leaveDAO;
	
	public List<LeaveDTO> getAllLeave() throws BusinessServiceException {
		List<LeaveDTO> leave= null;
		try {
			logger.info("Getting the Leave data...");
			leave = leaveDAO.getAllLeave();
			logger.info("Leave data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leave;

	}
	public List<LeaveDTO> getLeaveByUser(LeaveDTO leaveDTO) throws BusinessServiceException {
		List<LeaveDTO> leaveByUserId= null;
		Leave leave=new Leave();
		User user=new User();
		user.setRegisterNumber(leaveDTO.getUserId());;
		leave.setUser(user);
		try {
			logger.info("Getting the Leave data...");
			leaveByUserId = leaveDAO.getLeaveByUser(leave);
			logger.info("Leave data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leaveByUserId;

	}
	public List<LeaveDTO> getLeaveByLeaveType(LeaveDTO leaveDTO) throws BusinessServiceException {
		List<LeaveDTO> leaveByLeaveType= null;
		Leave leave=new Leave();
		LeaveType leaveType=new LeaveType();
		leaveType.setId(leaveDTO.getLeaveId());
		leave.setLeaveType(leaveType);
		try {
			logger.info("Getting the Leave data...");
			leaveByLeaveType = leaveDAO.getLeaveByLeaveType(leave);
			logger.info("Leave data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leaveByLeaveType;

	}


}
