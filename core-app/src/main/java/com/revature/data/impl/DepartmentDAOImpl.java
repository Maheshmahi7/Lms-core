package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.DepartmentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Department;
import com.revature.model.dto.DepartmentDTO;



@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	private static Logger logger =Logger.getLogger(DepartmentDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<DepartmentDTO> getAllDepartment() throws DataServiceException {
		List<DepartmentDTO> department = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive from department ");
			department = dataRetriver.retrieveBySQLAsJSON(sb.toString(),DepartmentDTO.class);
			logger.info("Department data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return department;
	}

	public DepartmentDTO getDepartmentById(Department department) throws DataServiceException {
		DepartmentDTO departmentById = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive from department  where ID=" + department.getId());
			departmentById = (DepartmentDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),DepartmentDTO.class);
			logger.info("Department by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departmentById;
	}

	
	public List<DepartmentDTO> getDepartmentByName(Department department) throws DataServiceException {
		List<DepartmentDTO> departmentByName = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,IS_ACTIVE isActive  from department  where Name='" + department.getName() + "'");
			departmentByName = dataRetriver.retrieveBySQLAsJSON(sb.toString(),DepartmentDTO.class);
			logger.info("Department by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return departmentByName;
	}

	


}
