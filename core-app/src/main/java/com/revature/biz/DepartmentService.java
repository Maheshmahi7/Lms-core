package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.DepartmentDTO;

public interface DepartmentService {
	
	public List<DepartmentDTO> getAllDepartment() throws BusinessServiceException;
	
	public <E> DepartmentDTO getDepartmentById(DepartmentDTO departmentDTO) throws BusinessServiceException;
	
	public List<DepartmentDTO> getDepartmentByName(DepartmentDTO departmentDTO) throws BusinessServiceException;


}
