package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Leave;
import com.revature.model.dto.LeaveDTO;

public interface LeaveDAO {
	public List<LeaveDTO> getAllLeave() throws DataServiceException;
	
	public List<LeaveDTO> getLeaveByUser(Leave leave) throws DataServiceException;

	public List<LeaveDTO> getLeaveByLeaveType(Leave leave) throws DataServiceException;
	
	public List<LeaveDTO> getLeaveByUserId(Leave leave) throws DataServiceException;



}
