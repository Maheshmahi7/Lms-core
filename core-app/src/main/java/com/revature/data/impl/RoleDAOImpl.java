package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.RoleDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Role;
import com.revature.model.dto.RoleDTO;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	private static Logger logger =Logger.getLogger(RoleDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<RoleDTO> getAllRole() throws DataServiceException {
		List<RoleDTO> role = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive from role ");
			role = dataRetriver.retrieveBySQLAsJSON(sb.toString(),RoleDTO.class);
			logger.info("Role data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return role;
	}

	public RoleDTO getRoleById(Role role) throws DataServiceException {
		RoleDTO roleById = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive from Role  where ID=" + role.getId());
			roleById = (RoleDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),RoleDTO.class);
			logger.info("Role by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roleById;
	}

	
	public List<RoleDTO> getRoleByName(Role role) throws DataServiceException {
		List<RoleDTO> roleByName = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive  from role  where Name='" + role.getName() + "'");
			roleByName = dataRetriver.retrieveBySQLAsJSON(sb.toString(),RoleDTO.class);
			logger.info("Role by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roleByName;
	}


}
