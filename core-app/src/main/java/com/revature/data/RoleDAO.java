package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Role;
import com.revature.model.dto.RoleDTO;

public interface RoleDAO {
	public List<RoleDTO> getAllRole() throws DataServiceException;
	
	public <E> RoleDTO getRoleById(Role role) throws DataServiceException;
	
	public List<RoleDTO> getRoleByName(Role role) throws DataServiceException;


}
