package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.LeaveService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.LeaveDTO;

@CrossOrigin
@RestController
@RequestMapping("/leave")
public class LeaveController {

	private static Logger logger=Logger.getLogger(LeaveController.class);

	@Autowired
	private LeaveService leaveService;
	
	@GetMapping("/")
	public List<LeaveDTO> getAllLeave() throws Exception {
		List<LeaveDTO> leave= null;
		try {
			logger.info("Getting the Leave data...");
			leave = leaveService.getAllLeave();
			logger.info("Leave data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leave;

	}
	@GetMapping("/user/{userId}")
	public List<LeaveDTO> getLeaveByUser(@PathVariable("userId") String userId) throws Exception {
		List<LeaveDTO> leaveByUserId= null;
		LeaveDTO leaveDTO=new LeaveDTO();
		leaveDTO.setUserId(userId);
		try {
			logger.info("Getting the Leave data...");
			leaveByUserId = leaveService.getLeaveByUser(leaveDTO);
			logger.info("Leave data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveByUserId;

	}
	@GetMapping("/leaveType/{leaveType}")
	public List<LeaveDTO> getLeaveByLeaveType(@PathVariable("leaveType") Integer leaveType) throws Exception {
		List<LeaveDTO> leaveByLeaveType= null;
		LeaveDTO leaveDTO=new LeaveDTO();
		leaveDTO.setLeaveId(leaveType);
		try {
			logger.info("Getting the Leave data...");
			leaveByLeaveType = leaveService.getLeaveByLeaveType(leaveDTO);
			logger.info("Leave data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveByLeaveType;

	}
	@GetMapping("/user/{userId}/{leaveType}")
	public List<LeaveDTO> getLeaveByUserId(@PathVariable("userId") String userId,@PathVariable("leaveType") Integer leaveType) throws Exception {
		List<LeaveDTO> leaveByUserId= null;
		LeaveDTO leaveDTO=new LeaveDTO();
		leaveDTO.setUserId(userId);
		leaveDTO.setLeaveId(leaveType);
		try {
			logger.info("Getting the Leave data...");
			leaveByUserId = leaveService.getLeaveByUserId(leaveDTO);
			logger.info("Leave data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leaveByUserId;

	}



}
