package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.StatusDTO;


public interface StatusService {
	
	public List<StatusDTO> getAllStatus() throws BusinessServiceException;

	public <E> StatusDTO getStatusById(StatusDTO statusDTO) throws BusinessServiceException;

	public List<StatusDTO> getStatusByName(StatusDTO statusDTO) throws BusinessServiceException;


}
