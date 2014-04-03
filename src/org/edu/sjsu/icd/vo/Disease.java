package org.edu.sjsu.icd.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class to hold the disease related information.
 * 
 * @author Deepti
 */
@XmlRootElement
public class Disease {

	/**
	 * International disease classification code assigned by WHO.
	 */
	private String icdCode;

	/**
	 * Short description of the disease along with the possible cause.
	 */
	private String description;

	/**
	 * Default Constructor
	 */
	public Disease() {

	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param icdCode ICD code
	 * @param description Description of the disease
	 */
	public Disease(String icdCode, String description) {
		this.icdCode = icdCode;
		this.description = description;
	}

	/**
	 * Gets the international disease classification code assigned by WHO.
	 * 
	 * @return ICD Code
	 */
	public String getIcdCode() {
		return icdCode;
	}

	/**
	 * Gets the short description of the disease along with the possible cause.
	 * 
	 * @return Description of the disease
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the international disease classification code assigned by WHO.
	 * 
	 * @param icdCode ICD Code
	 */
	@XmlElement(name = "icd-code")
	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	/**
	 * Sets the short description of the disease along with the possible cause.
	 * 
	 * @param description Description of the disease
	 */
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Overloaded toString method.
	 * 
	 * @return String
	 */
	public String toString() {
		return "ICD Code: " + icdCode + " | Description: " + description;
	}
}
