package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StatusService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StatusDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Status;
import com.revature.model.dto.StatusDTO;

@Service
public class StatusServiceImpl implements StatusService{
	private static Logger logger=Logger.getLogger(StatusServiceImpl.class);
	
	@Autowired
	private StatusDAO statusDAO;
	
	public List<StatusDTO> getAllStatus() throws BusinessServiceException {
		List<StatusDTO> status= null;
		try {
			logger.info("Getting the Status data...");
			status = statusDAO.getAllStatus();
			logger.info("Status data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);	
		}
		return status;

	}
	public StatusDTO getStatusById(StatusDTO statusDTO) throws BusinessServiceException {
		StatusDTO statusById= null;
		Status status=new Status();
		status.setId(statusDTO.getId());
		try {
			logger.info("Getting the Status data...");
			statusById = statusDAO.getStatusById(status);
			logger.info("Status data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return statusById;

	}
	public List<StatusDTO> getStatusByName(StatusDTO statusDTO) throws BusinessServiceException {
		List<StatusDTO> statusByName= null;
		Status status=new Status();
		status.setName(statusDTO.getName());
		try {
			logger.info("Getting the Status data...");
			statusByName = statusDAO.getStatusByName(status);
			logger.info("Status data retrieval success.");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return statusByName;

	}


}
