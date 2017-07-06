package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

public interface UserDAO {
	
	public List<UserDTO> getAllUser() throws DataServiceException;
	
	public <E> UserDTO getUserById(User user) throws DataServiceException;

	public List<UserDTO> getUserByName(User user) throws DataServiceException;
	
	public List<UserDTO> getUserByDepartment(User user) throws DataServiceException;
	
	public List<UserDTO> getUserByRole(User user) throws DataServiceException;

	public <E> UserDTO getUserByLogin(User user) throws DataServiceException;


}
