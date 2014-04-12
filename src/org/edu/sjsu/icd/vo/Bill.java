/**
 * 
 */
package org.edu.sjsu.icd.vo;

/**
 * @author Deepti
 * 
 */
public class Bill {
	private String firstName;
	private String lastName;
	private String billNumber;
	private String symptoms;
	private String billingDate;
	private String billIcd;
	private String suggestedIcd;

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
	 * @return the billNumber
	 */
	public String getBillNumber() {
		return billNumber;
	}

	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	/**
	 * @return the billingDate
	 */
	public String getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate the billingDate to set
	 */
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

	/**
	 * @return the symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}

	/**
	 * @param symptoms the symptoms to set
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	/**
	 * @return the billIcd
	 */
	public String getBillIcd() {
		return billIcd;
	}

	/**
	 * @param billIcd the billIcd to set
	 */
	public void setBillIcd(String billIcd) {
		this.billIcd = billIcd;
	}

	/**
	 * @return the suggestedIcd
	 */
	public String getSuggestedIcd() {
		return suggestedIcd;
	}

	/**
	 * @param suggestedIcd the suggestedIcd to set
	 */
	public void setSuggestedIcd(String suggestedIcd) {
		this.suggestedIcd = suggestedIcd;
	}
}
