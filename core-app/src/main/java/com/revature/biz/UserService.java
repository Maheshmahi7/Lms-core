package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.UserDTO;

public interface UserService {
	
	public List<UserDTO> getAllUser() throws BusinessServiceException;
	
	public <E> UserDTO getUserById(UserDTO userDTO) throws BusinessServiceException;

	public List<UserDTO> getUserByName(UserDTO userDTO) throws BusinessServiceException;
	
	public List<UserDTO> getUserByDepartment(UserDTO userDTO) throws BusinessServiceException;
	
	public List<UserDTO> getUserByRole(UserDTO userDTO) throws BusinessServiceException;

	UserDTO getUserByLogin(UserDTO userDTO) throws BusinessServiceException;


}
