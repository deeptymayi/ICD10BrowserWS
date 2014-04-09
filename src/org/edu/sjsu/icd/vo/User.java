package org.edu.sjsu.icd.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class to hold the disease related information.
 * 
 * @author Pratibha
 */
@XmlRootElement
public class User {

	/**
	 * First Name
	 */
	@XmlElement
	private String firstName;

	/**
	 * Last Name
	 */
	@XmlElement
	private String lastName;

	/**
	 * User Name
	 */
	@XmlElement
	private String userName;

	/**
	 * Password
	 */
	@XmlElement
	private String password;

	/**
	 * Default Constructor
	 */
	public User() {

	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param userName User Name
	 * @param password Password
	 */
	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Overloaded toString method.
	 * 
	 * @return String
	 */
	public String toString() {
		return "First Name: " + this.firstName + ", Last Name: " + this.lastName + ", User Name: "
		        + this.userName + ", Password: " + this.password;
	}
}
