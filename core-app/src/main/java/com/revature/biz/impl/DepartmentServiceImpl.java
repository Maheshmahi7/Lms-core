package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.DepartmentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.DepartmentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;
import com.revature.model.dto.DepartmentDTO;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private static Logger logger=Logger.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentDAO departmentDAO;
	
	public List<DepartmentDTO> getAllDepartment() throws BusinessServiceException {
		List<DepartmentDTO> department= null;
		try {
			logger.info("Getting the Department data...");
			department = departmentDAO.getAllDepartment();
			logger.info("Department data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return department;

	}
	public DepartmentDTO getDepartmentById(DepartmentDTO departmentDTO) throws BusinessServiceException {
		DepartmentDTO departmentById= null;
		Department department=new Department();
		department.setId(departmentDTO.getId());;
		try {
			logger.info("Getting the Department data...");
			departmentById = departmentDAO.getDepartmentById(department);
			logger.info("Department data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentById;

	}
	public List<DepartmentDTO> getDepartmentByName(DepartmentDTO departmentDTO) throws BusinessServiceException {
		List<DepartmentDTO> departmentByName= null;
		Department department=new Department();
		department.setName(departmentDTO.getName());
		try {
			logger.info("Getting the Department data...");
			departmentByName = departmentDAO.getDepartmentByName(department);
			logger.info("Department data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentByName;

	}


}
