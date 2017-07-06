package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StatusService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;

import com.revature.model.dto.StatusDTO;




@RestController
@RequestMapping("/Status")
public class StatusController {
	
	private static Logger logger=Logger.getLogger(StatusController.class);
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/")
	public List<StatusDTO> getAllStatus() throws Exception {
		List<StatusDTO> status= null;
		try {
			logger.info("Getting the Status data...");
			status = statusService.getAllStatus();
			logger.info("Status data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return status;

	}
	@GetMapping("/{statusId}")
	public StatusDTO getStatusById(@PathVariable("statusId") Integer statusId) throws Exception {
		StatusDTO statusById= null;
		StatusDTO statusDTO=new StatusDTO();
		statusDTO.setId(statusId);
		try {
			logger.info("Getting the Status data...");
			statusById = statusService.getStatusById(statusDTO);
			logger.info("Status data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return statusById;

	}
	@GetMapping("/Name/{statusName}")
	public List<StatusDTO> getStatusByName(@PathVariable("statusName") String statusName) throws Exception {
		List<StatusDTO> statusByName= null;
		StatusDTO statusDTO=new StatusDTO();
		statusDTO.setName(statusName);
		try {
			logger.info("Getting the Status data...");
			statusByName = statusService.getStatusByName(statusDTO);
			logger.info("Status data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return statusByName;

	}


}
