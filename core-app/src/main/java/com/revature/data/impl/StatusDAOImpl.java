package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StatusDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Status;
import com.revature.model.dto.StatusDTO;


@Repository
public class StatusDAOImpl implements StatusDAO{
	private static Logger logger =Logger.getLogger(StatusDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<StatusDTO> getAllStatus() throws DataServiceException {
		List<StatusDTO> status = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name from status ");
			status = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StatusDTO.class);
			logger.info("Status data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return status;
	}

	public StatusDTO getStatusById(Status status) throws DataServiceException {
		StatusDTO statusById = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name from status where ID=" + status.getId());
			statusById = (StatusDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),StatusDTO.class);
			logger.info("Status by id data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return statusById;
	}

	
	public List<StatusDTO> getStatusByName(Status status) throws DataServiceException {
		List<StatusDTO> statusByName = null;
		try {
			StringBuilder sb = new StringBuilder("select ID id,NAME name from status where Name='" + status.getName() + "'");
			statusByName = dataRetriver.retrieveBySQLAsJSON(sb.toString(),StatusDTO.class);
			logger.info("Status by name data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return statusByName;
	}

	

}
