package org.edu.sjsu.icd.service;

import org.edu.sjsu.icd.dao.IRegistrationDAO;
import org.edu.sjsu.icd.utils.ObjectJsonBidirectionalConverter;
import org.edu.sjsu.icd.vo.User;

/**
 * 
 * 
 * @author Deepti
 */
public class AuthenticationService {

	/**
	 * Registration DAO object.
	 */
	private IRegistrationDAO registrationDAO;

	/**
	 * 
	 * 
	 */
	public boolean signup(User user) {
		return registrationDAO.persistNewUser(user);
	}

	/**
	 * 
	 * 
	 */
	public String login(String userName, String password) {
		User user = registrationDAO.fetchUserDetails(userName, password);
		
		String result = null;
		if(user != null) {
			result = ObjectJsonBidirectionalConverter.toJson(user);
		}
		
		return result;
	}

	/**
	 * Sets the IRegistrationDAO object.
	 * 
	 * @param registrationDAO {@link IRegistrationDAO}
	 */
	public void setRegistrationDAO(IRegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}
}
