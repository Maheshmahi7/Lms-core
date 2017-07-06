package com.revature.data.access;

import com.revature.data.access.exception.DataAccessException;

public interface DataModifier {
	/**
	 * Used to get the data by sql query.
	 * 
	 * @param query
	 *            query to execute
	 * @return the requested data
	 * @throws DataAccessException
	 *             if query format error
	 */
	public int retrieveBySQL(String query) throws DataAccessException;

}
