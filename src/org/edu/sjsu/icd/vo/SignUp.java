package org.edu.sjsu.icd.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class to hold the disease related information.
 * 
 * @author Pratibha
 */
@XmlRootElement
public class SignUp {

	/**
	 * First Name
	 */
	private String firstName;

	/**
	 * Last Name
	 */
	private String lastName;
	
	/**
	 * User Name
	 */
	private String userName;
	
	/**
	 * Password
	 */
	private String password;

	/**
	 * Default Constructor
	 */
	public SignUp() {

	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param icdCode ICD code
	 * @param description Description of the disease
	 */
	public SignUp(String firstName, String lastName, String userName, String password) {
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Overloaded toString method.
	 * 
	 * @return String
	 */
	public String toString(){
        return "Name="+this.firstName+", Email="+this.lastName+", Country="+this.userName;
    }

}
