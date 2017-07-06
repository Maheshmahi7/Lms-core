package com.revature.data.access;

import java.util.List;

import com.revature.data.access.exception.DataAccessException;

public interface DataRetriver {
	/**
	 * Used to get the data by sql query.
	 * 
	 * @param query
	 *            query to execute
	 * @return the requested data
	 * @throws DataAccessException
	 *             if query format error
	 */

	@SuppressWarnings("rawtypes")
	public <E> List<E> retrieveBySQLAsJSON(String query, Class className) throws DataAccessException;

	@SuppressWarnings("rawtypes")
	public <E> Object retrieveBySQLAsObject(String query, Class className) throws DataAccessException;
	
	public <E> List<E> retrieveBySQLAsJSONInDAO(String queryString) throws DataAccessException;

}
