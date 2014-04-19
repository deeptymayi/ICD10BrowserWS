package org.edu.sjsu.icd.dao.impl;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IRegistrationDAO;
import org.edu.sjsu.icd.vo.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class RegistrationDAOImpl implements IRegistrationDAO {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Set the data source object.
	 * 
	 * @param dataSource
	 *            {@link DataSource}
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean persistNewUser(User user) {
		// Query to insert user details to the Registration table
		String query = "INSERT INTO REGISTRATION (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";

		int result = 0;
		boolean returnValue = false;

		try {
			// Create a query using the JDBC template and insert the record.
			result = jdbcTemplate.update(
			        query,
			        new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(),
			                user.getPassword() });
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

	public User fetchUserDetails(String userName, String password) {

		// Query to retrieve User record
		String query = "SELECT * FROM REGISTRATION WHERE USERNAME=? AND PASSWORD=?";

		User user = null;

		try {
			// Create a query using the JDBC template and fetch the record.
			user = jdbcTemplate.queryForObject(query, new Object[] { userName, password },
			        new BeanPropertyRowMapper<User>(User.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		return user;
	}

}
