package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.UserDTO;

@RestController
@RequestMapping("/User")
public class UserController {
	
	private static Logger logger=Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<UserDTO> getAllUser() throws Exception {
		List<UserDTO> user= null;
		try {
			logger.info("Getting the User data...");
			user = userService.getAllUser();
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return user;

	}
	@GetMapping("/{userId}")
	public UserDTO getUserById(@PathVariable("userId") String userId) throws Exception {
		UserDTO userById= null;
		UserDTO userDTO=new UserDTO();
		userDTO.setRegistorNumber(userId);
		try {
			logger.info("Getting the User data...");
			userById = userService.getUserById(userDTO);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userById;

	}
	@GetMapping("/Name/{userName}")
	public List<UserDTO> getUserByName(@PathVariable("userName") String userName) throws Exception {
		List<UserDTO> userByName= null;
		UserDTO userDTO=new UserDTO();
		userDTO.setName(userName);
		try {
			logger.info("Getting the User data...");
			userByName = userService.getUserByName(userDTO);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByName;

	}
	@GetMapping("/Role/{roleId}")
	public List<UserDTO> getUserByRole(@PathVariable("roleId") Integer roleId) throws Exception {
		List<UserDTO> userByName= null;
		UserDTO userDTO=new UserDTO();
		userDTO.setRoleId(roleId);
		try {
			logger.info("Getting the User data...");
			userByName = userService.getUserByRole(userDTO);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByName;

	}
	@GetMapping("/Department/{departmentId}")
	public List<UserDTO> getUserByDepartment(@PathVariable("departmentId") Integer departmentId) throws Exception {
		List<UserDTO> userByName= null;
		UserDTO userDTO=new UserDTO();
		userDTO.setDepartmentId(departmentId);
		try {
			logger.info("Getting the User data...");
			userByName = userService.getUserByDepartment(userDTO);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userByName;

	}
	@PostMapping("/login")
	public UserDTO getUserByEmailId(@RequestParam("emailId") String emailId, @RequestParam("password") String password ) throws Exception {
		UserDTO userDTO=new UserDTO();
		userDTO.setEmailId(emailId);
		userDTO.setPassword(password);
		try {
			logger.info("Getting the User data...");
			userDTO = userService.getUserByLogin(userDTO);
			logger.info("User data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return userDTO;

	}


}
