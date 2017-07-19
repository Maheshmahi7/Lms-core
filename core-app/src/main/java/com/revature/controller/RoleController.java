package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.RoleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.RoleDTO;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
	
	private static Logger logger=Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/")
	public List<RoleDTO> getAllRole() throws Exception {
		List<RoleDTO> role= null;
		try {
			logger.info("Getting the Role data...");
			role = roleService.getAllRole();
			logger.info("Role data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return role;

	}
	@GetMapping("/{roleId}")
	public RoleDTO getRoleById(@PathVariable("roleId") Integer roleId) throws Exception {
		RoleDTO roleById= null;
		RoleDTO roleDTO=new RoleDTO();
		roleDTO.setId(roleId);;
		try {
			logger.info("Getting the Role data...");
			roleById = roleService.getRoleById(roleDTO);
			logger.info("Role data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return roleById;

	}
	@GetMapping("/name/{roleName}")
	public List<RoleDTO> getRoleByName(@PathVariable("roleName") String roleName) throws Exception {
		List<RoleDTO> roleByName= null;
		RoleDTO roleDTO=new RoleDTO();
		roleDTO.setName(roleName);
		try {
			logger.info("Getting the Role data...");
			roleByName = roleService.getRoleByName(roleDTO);
			logger.info("Role data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return roleByName;

	}


}
