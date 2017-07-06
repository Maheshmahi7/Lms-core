package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Status;
import com.revature.model.dto.StatusDTO;


public interface StatusDAO {

	public List<StatusDTO> getAllStatus() throws DataServiceException;
	
	public <E> StatusDTO getStatusById(Status status) throws DataServiceException;

	public List<StatusDTO> getStatusByName(Status status) throws DataServiceException;

}
