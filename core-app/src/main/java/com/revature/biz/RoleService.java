package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.RoleDTO;

public interface RoleService {
	
	public List<RoleDTO> getAllRole() throws BusinessServiceException;
	
	public <E> RoleDTO getRoleById(RoleDTO roleDTO) throws BusinessServiceException;
	
	public List<RoleDTO> getRoleByName(RoleDTO roleDTO) throws BusinessServiceException;


}
