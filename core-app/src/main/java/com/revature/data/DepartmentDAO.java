package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;
import com.revature.model.dto.DepartmentDTO;

public interface DepartmentDAO {
	
	public List<DepartmentDTO> getAllDepartment() throws DataServiceException;
	
	public <E> DepartmentDTO getDepartmentById(Department department) throws DataServiceException;
	
	public List<DepartmentDTO> getDepartmentByName(Department department) throws DataServiceException;

}
