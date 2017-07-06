package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.UserDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	private static Logger logger=Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;
	
	public List<UserDTO> getAllUser() throws BusinessServiceException {
		List<UserDTO> user= null;
		try {
			logger.info("Getting the User data...");
			user = userDAO.getAllUser();
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return user;

	}
	public UserDTO getUserById(UserDTO userDTO) throws BusinessServiceException {
		UserDTO userById= null;
		User user=new User();
		user.setRegisterNumber(userDTO.getRegistorNumber());
		try {
			logger.info("Getting the User data...");
			userById = userDAO.getUserById(user);
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return userById;

	}
	public List<UserDTO> getUserByName(UserDTO userDTO) throws BusinessServiceException {
		List<UserDTO> userByName= null;
		User user=new User();
		user.setName(userDTO.getName());
		try {
			logger.info("Getting the User data...");
			userByName = userDAO.getUserByName(user);
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return userByName;

	}
	public List<UserDTO> getUserByRole(UserDTO userDTO) throws BusinessServiceException {
		List<UserDTO> userByName= null;
		User user=new User();
		Role role=new Role();
		role.setId(userDTO.getRoleId());
		user.setRole(role);
		try {
			logger.info("Getting the User data...");
			userByName = userDAO.getUserByRole(user);
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return userByName;

	}
	public List<UserDTO> getUserByDepartment(UserDTO userDTO) throws BusinessServiceException {
		List<UserDTO> userByName= null;
		User user=new User();
		Department department=new Department();
		department.setId(userDTO.getDepartmentId());
		user.setDepartment(department);
		try {
			logger.info("Getting the User data...");
			userByName = userDAO.getUserByDepartment(user);
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return userByName;

	}
	public UserDTO getUserByLogin(UserDTO userDTO) throws BusinessServiceException {
		UserDTO userByLogin= null;
		try {
		User user=new User();
		user.setEmailId(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());
			logger.info("Getting the User data...");
			userByLogin = userDAO.getUserByLogin(user);
			logger.info("User data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return userByLogin;

	}


}
