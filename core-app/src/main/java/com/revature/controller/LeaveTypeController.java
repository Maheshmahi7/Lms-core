package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.LeaveTypeService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.LeaveTypeDTO;

@CrossOrigin
@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {
	private static Logger logger=Logger.getLogger(LeaveTypeController.class);

	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@GetMapping("/")
	public List<LeaveTypeDTO> getAllLeaveType() throws Exception {
		List<LeaveTypeDTO> leaveType= null;
		try {
			logger.info("Getting the LeaveType data...");
			leaveType = leaveTypeService.getAllLeaveType();
			logger.info("LeaveType data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveType;

	}
	@GetMapping("/{leaveTypeId}")
	public LeaveTypeDTO getLeaveTypeById(@PathVariable("leaveTypeId") Integer leaveTypeId) throws Exception {
		LeaveTypeDTO leaveTypeById= null;
		LeaveTypeDTO leaveTypeDTO=new LeaveTypeDTO();
		leaveTypeDTO.setId(leaveTypeId);;
		try {
			logger.info("Getting the LeaveType data...");
			leaveTypeById = leaveTypeService.getLeaveTypeById(leaveTypeDTO);
			logger.info("LeaveType data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveTypeById;

	}
	@GetMapping("/name/{leaveTypeName}")
	public List<LeaveTypeDTO> getLeaveTypeByName(@PathVariable("leaveTypeName") String leaveTypeName) throws Exception {
		List<LeaveTypeDTO> leaveTypeByName= null;
		LeaveTypeDTO leaveTypeDTO=new LeaveTypeDTO();
		leaveTypeDTO.setName(leaveTypeName);
		try {
			logger.info("Getting the LeaveType data...");
			leaveTypeByName = leaveTypeService.getLeaveTypeByName(leaveTypeDTO);
			logger.info("LeaveType data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveTypeByName;

	}


}
