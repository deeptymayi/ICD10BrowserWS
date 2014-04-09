package org.edu.sjsu.icd.dao;

import org.edu.sjsu.icd.vo.User;

/**
 * DAO class responsible for reading and writing sign-up and login information
 * to/from the DB table.
 * 
 * @author Deepti
 */
public interface IRegistrationDAO {

	/**
	 * Created a new user from the details provided in the sign-`up page.
	 * 
	 * @param user Object holding User information.
	 * @return true if the registration was successful.
	 */
	public boolean persistNewUser(User user);

	/**
	 * Validates the user name and password against the data in registration
	 * table.
	 * 
	 * @param userName User name string
	 * @param password Password
	 * @return Corresponding User object if the user name and password are
	 *         valid, else returns null.
	 */
	public User fetchUserDetails(String userName, String password);
}
