package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.UserDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.User;
import com.revature.model.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	private static Logger logger =Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<UserDTO> getAllUser() throws DataServiceException{
		List<UserDTO> user = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user");
			user = dataRetriver.retrieveBySQLAsJSON(sb.toString(),UserDTO.class);
			logger.info("User data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return user;
	}

	public UserDTO getUserById(User user) throws DataServiceException {
		UserDTO userById=null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where REGISTOR_NUMBER ='" + user.getRegisterNumber() +"'");
			userById = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),UserDTO.class);
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userById;
	}

	
	public List<UserDTO> getUserByName(User user) throws DataServiceException {
		List<UserDTO> userByName = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where Name='" + user.getName() + "'");
			userByName = dataRetriver.retrieveBySQLAsJSON(sb.toString(),UserDTO.class);
			logger.info("User by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByName;
	}
	public List<UserDTO> getUserByRole(User user) throws DataServiceException {
		List<UserDTO> userByRole = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where ROLE_ID=" + user.getRole().getId());
			userByRole = dataRetriver.retrieveBySQLAsJSON(sb.toString(),UserDTO.class);
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByRole;
	}
	public List<UserDTO> getUserByDepartment(User user) throws DataServiceException {
		List<UserDTO> userByDepartment = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where DEPARTMENT_ID=" + user.getDepartment().getId());
			userByDepartment = dataRetriver.retrieveBySQLAsJSON(sb.toString(),UserDTO.class);
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByDepartment;
	}
/*	public <E> UserDTO getUserByLogin(User user) throws DataServiceException {
		UserDTO userByEmailId = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where EMAIL_ID='"+user.getEmailId()+"' and PASSWORD='"+user.getPassword()+"'");
			userByEmailId = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),UserDTO.class);
			logger.info("User by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userByEmailId;
	}*/
@Override
	public <E> UserDTO getUserByLogin(User user) throws DataServiceException {
		UserDTO userDTO = null;
		UserDTO userDTO1=null;
		try {
			StringBuilder sb = new StringBuilder(
					"select u.password from user u where u.EMAIL_ID='" + user.getEmailId() + "' and u.IS_ACTIVE=true");
			userDTO = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), UserDTO.class);
			String dbPassword = userDTO.getPassword();
			String enteredPassword = user.getPassword(); 
			logger.info("Pass-db     " + dbPassword);
			if (enteredPassword.equals(dbPassword)) {
				logger.info("User login success...");
				StringBuilder sb1 = new StringBuilder(
						"select ID id,REGISTOR_NUMBER registorNumber,NAME name,ROLE_ID roleId,DEPARTMENT_ID departmentId,EMAIL_ID emailId,PASSWORD password,PHONE_NUMBER phone,IS_ACTIVE isActive from user where EMAIL_ID='"+user.getEmailId()+"'");
				userDTO1 = (UserDTO) dataRetriver.retrieveBySQLAsObject(sb1.toString(), UserDTO.class);
			} else
				logger.info("User login failure...");
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return userDTO1;
	}


}
