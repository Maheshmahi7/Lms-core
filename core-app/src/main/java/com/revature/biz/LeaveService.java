package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.LeaveDTO;

public interface LeaveService {
	public List<LeaveDTO> getAllLeave() throws BusinessServiceException;
	
	public List<LeaveDTO> getLeaveByUser(LeaveDTO leaveDTO) throws BusinessServiceException;

	public List<LeaveDTO> getLeaveByLeaveType(LeaveDTO leaveDTO) throws BusinessServiceException;


}
