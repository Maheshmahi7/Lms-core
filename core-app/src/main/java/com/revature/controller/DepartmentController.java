package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.DepartmentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.DepartmentDTO;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
	private static Logger logger=Logger.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	public List<DepartmentDTO> getAllDepartment() throws Exception {
		List<DepartmentDTO> department= null;
		try {
			logger.info("Getting the Department data...");
			department = departmentService.getAllDepartment();
			logger.info("Department data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return department;

	}
	@GetMapping("/{departmentId}")
	public DepartmentDTO getDepartmentById(@PathVariable("departmentId") Integer departmentId) throws Exception {
		DepartmentDTO departmentById= null;
		DepartmentDTO departmentDTO=new DepartmentDTO();
		departmentDTO.setId(departmentId);;
		try {
			logger.info("Getting the Department data...");
			departmentById = departmentService.getDepartmentById(departmentDTO);
			logger.info("Department data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return departmentById;

	}
	@GetMapping("/Name/{departmentName}")
	public List<DepartmentDTO> getDepartmentByName(@PathVariable("departmentName") String departmentName) throws Exception {
		List<DepartmentDTO> departmentByName= null;
		DepartmentDTO departmentDTO=new DepartmentDTO();
		departmentDTO.setName(departmentName);
		try {
			logger.info("Getting the Department data...");
			departmentByName = departmentService.getDepartmentByName(departmentDTO);
			logger.info("Department data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return departmentByName;

	}



}
