package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.LeaveTypeDTO;

public interface LeaveTypeService {

	public List<LeaveTypeDTO> getAllLeaveType() throws BusinessServiceException;
	
	public <E> LeaveTypeDTO getLeaveTypeById(LeaveTypeDTO leaveTypeDTO) throws BusinessServiceException;
	
	public List<LeaveTypeDTO> getLeaveTypeByName(LeaveTypeDTO leaveTypeDTO) throws BusinessServiceException;


}
