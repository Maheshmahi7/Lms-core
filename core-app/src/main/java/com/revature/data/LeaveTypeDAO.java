package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.LeaveType;
import com.revature.model.dto.LeaveTypeDTO;

public interface LeaveTypeDAO {
	public List<LeaveTypeDTO> getAllLeaveType() throws DataServiceException;
	
	public <E> LeaveTypeDTO getLeaveTypeById(LeaveType leaveType) throws DataServiceException;
	
	public List<LeaveTypeDTO> getLeaveTypeByName(LeaveType leaveType) throws DataServiceException;


}
