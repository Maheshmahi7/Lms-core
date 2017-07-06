package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.RoleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.RoleDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Role;
import com.revature.model.dto.RoleDTO;

@Service
public class RoleServiceImpl implements RoleService{
	private static Logger logger=Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDAO roleDAO;
	
	public List<RoleDTO> getAllRole() throws BusinessServiceException {
		List<RoleDTO> role= null;
		try {
			logger.info("Getting the Role data...");
			role = roleDAO.getAllRole();
			logger.info("Role data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return role;

	}
	public RoleDTO getRoleById(RoleDTO roleDTO) throws BusinessServiceException {
		RoleDTO roleById= null;
		Role role=new Role();
		role.setId(roleDTO.getId());
		try {
			logger.info("Getting the Role data...");
			roleById = roleDAO.getRoleById(role);
			logger.info("Role data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return roleById;

	}

	public List<RoleDTO> getRoleByName(RoleDTO roleDTO) throws BusinessServiceException {
		List<RoleDTO> roleByName= null;
		Role role=new Role();
		role.setName(roleDTO.getName());
		try {
			logger.info("Getting the Role data...");
			roleByName = roleDAO.getRoleByName(role);
			logger.info("Role data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		} 
		return roleByName;

	}


}
