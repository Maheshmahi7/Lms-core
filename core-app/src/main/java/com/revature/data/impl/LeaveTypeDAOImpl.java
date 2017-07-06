package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.LeaveTypeDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.LeaveType;
import com.revature.model.dto.LeaveTypeDTO;

@Repository
public class LeaveTypeDAOImpl implements LeaveTypeDAO{
	private static Logger logger =Logger.getLogger(LeaveTypeDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<LeaveTypeDTO> getAllLeaveType() throws DataServiceException {
		List<LeaveTypeDTO> leaveType = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,NO_OF_DAYS noOfDays,IS_ACTIVE isActive from leave_type ");
			leaveType = dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveTypeDTO.class);
			logger.info("Status data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveType;
	}

	public LeaveTypeDTO getLeaveTypeById(LeaveType leaveType) throws DataServiceException {
		LeaveTypeDTO leaveTypeById = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,NO_OF_DAYS noOfDays,IS_ACTIVE isActive from leave_type  where ID=" + leaveType.getId());
			leaveTypeById = (LeaveTypeDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),LeaveTypeDTO.class);
			logger.info("Status by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveTypeById;
	}

	
	public List<LeaveTypeDTO> getLeaveTypeByName(LeaveType leaveType) throws DataServiceException {
		List<LeaveTypeDTO> leaveTypeByName = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name,NO_OF_DAYS noOfDays,IS_ACTIVE isActive  from leave_type  where Name='" + leaveType.getName() + "'");
			leaveTypeByName = dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveTypeDTO.class);
			logger.info("Status by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveTypeByName;
	}


}
