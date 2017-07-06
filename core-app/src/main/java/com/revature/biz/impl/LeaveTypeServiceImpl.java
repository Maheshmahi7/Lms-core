package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.LeaveTypeService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.LeaveTypeDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.LeaveType;
import com.revature.model.dto.LeaveTypeDTO;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{
	private static Logger logger=Logger.getLogger(LeaveTypeServiceImpl.class);

	@Autowired
	private LeaveTypeDAO leaveTypeDAO;
	
	public List<LeaveTypeDTO> getAllLeaveType() throws BusinessServiceException {
		List<LeaveTypeDTO> leaveType= null;
		try {
			logger.info("Getting the LeaveType data...");
			leaveType = leaveTypeDAO.getAllLeaveType();
			logger.info("LeaveType data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return leaveType;

	}
	public LeaveTypeDTO getLeaveTypeById(LeaveTypeDTO leaveTypeDTO) throws BusinessServiceException {
		LeaveTypeDTO leaveTypeById= null;
		LeaveType leaveType=new LeaveType();
		leaveType.setId(leaveTypeDTO.getId());
		try {
			logger.info("Getting the LeaveType data...");
			leaveTypeById = leaveTypeDAO.getLeaveTypeById(leaveType);
			logger.info("LeaveType data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return leaveTypeById;

	}
	public List<LeaveTypeDTO> getLeaveTypeByName(LeaveTypeDTO leaveTypeDTO) throws BusinessServiceException {
		List<LeaveTypeDTO> leaveTypeByName= null;
		LeaveType leaveType=new LeaveType();
		leaveType.setName(leaveTypeDTO.getName());
		try {
			logger.info("Getting the LeaveType data...");
			leaveTypeByName = leaveTypeDAO.getLeaveTypeByName(leaveType);
			logger.info("LeaveType data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return leaveTypeByName;

	}


}
