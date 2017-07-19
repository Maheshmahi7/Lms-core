package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.LeaveDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Leave;
import com.revature.model.dto.LeaveDTO;

@Repository
public class LeaveDAOImpl implements LeaveDAO{
	private static Logger logger =Logger.getLogger(LeaveDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<LeaveDTO> getAllLeave() throws DataServiceException {
		List<LeaveDTO> leave = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,USER_ID UserId,LEAVE_ID leaveId,NO_OF_DAYS_REQUIRED noOfDaysRequired,APPLIED_DATE appliedDate,FROM_DATE fromDate,TO_DATE toDate,STATUS status from leaves");
			leave = dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveDTO.class);
			logger.info("Leave data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leave;
	}

	public List<LeaveDTO> getLeaveByUser(Leave leave) throws DataServiceException {
		List<LeaveDTO> leaveByUser = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,USER_ID UserId,LEAVE_ID leaveId,NO_OF_DAYS_REQUIRED noOfDaysRequired,APPLIED_DATE appliedDate,FROM_DATE fromDate,TO_DATE toDate,STATUS status from leaves where USER_ID='"+leave.getUser().getRegisterNumber()+"'");
			leaveByUser = dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveDTO.class);
			logger.info("Leave by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveByUser;
	}

	
	public List<LeaveDTO> getLeaveByLeaveType(Leave leave) throws DataServiceException {
		List<LeaveDTO> leaveByLeaveType = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,USER_ID UserId,LEAVE_ID leaveId,NO_OF_DAYS_REQUIRED noOfDaysRequired,APPLIED_DATE appliedDate,FROM_DATE fromDate,TO_DATE toDate,STATUS status from leaves where LEAVE_ID='" + leave.getLeaveType().getId() + "'");
			leaveByLeaveType = dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveDTO.class);
			logger.info("Leave by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveByLeaveType;
	}
	
	public LeaveDTO getLeaveByUserId(Leave leave) throws DataServiceException {
		LeaveDTO leaveByUserId = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT SUM(NO_OF_DAYS_REQUIRED) sum FROM LEAVES JOIN LEAVE_TYPE ON LEAVE_TYPE.`ID`=LEAVES.`LEAVE_ID` WHERE USER_ID='"+leave.getUser().getRegisterNumber()+"' AND LEAVE_ID="+leave.getLeaveType().getId());
			leaveByUserId = (LeaveDTO)dataRetriver.retrieveBySQLAsJSON(sb.toString(),LeaveDTO.class);
			logger.info("Leave by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveByUserId;
	}


}
