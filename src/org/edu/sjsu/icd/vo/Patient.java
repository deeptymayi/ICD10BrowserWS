package org.edu.sjsu.icd.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class to hold the User related information.
 * 
 * @author Deepti
 */
@XmlRootElement
public class Patient {

	/**
	 * First Name
	 */
	@XmlElement
	private String  patientId;

	/**
	 * First Name
	 */
	@XmlElement
	private String  firstName;

	/**
	 * Last Name
	 */
	@XmlElement
	private String  lastName;

	/**
	 * User Name
	 */
	@XmlElement
	private String  gender;

	/**
	 * 
	 */
	@XmlElement
	private Date    dob;

	/**
	 * 
	 */
	@XmlElement
	private int     phoneNumber;

	/**
	 * 
	 */
	@XmlElement
	private String  diagnosis;

	/**
	 * 
	 */
	@XmlElement
	private String  icdCode;

	/**
	 * 
	 */
	@XmlElement
	private String  addressLine1;

	/**
	 * 
	 */
	@XmlElement
	private String  addressLine2;

	/**
	 * 
	 */
	@XmlElement
	private String  city;

	/**
	 * 
	 */
	@XmlElement
	private String  state;

	/**
	 * 
	 */
	@XmlElement
	private Integer zipCode;

	/**
	 * 
	 */
	@XmlElement
	private String  medicines;

	/**
	 * 
	 */
	@XmlElement
	private String  dosage;
	
	/**
	 * 
	 */
	@XmlElement
	private Date  billingDate;

	/**
	 * 
	 */
	@XmlElement
	private String  billNumber;

	/**
	 * 
	 */
	@XmlElement
	private Double  billAmount;

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the icdCode
	 */
	public String getIcdCode() {
		return icdCode;
	}

	/**
	 * @param icdCode the icdCode to set
	 */
	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the medicines
	 */
	public String getMedicines() {
		return medicines;
	}

	/**
	 * @param medicines the medicines to set
	 */
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	/**
	 * @return the billingDate
	 */
	public Date getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate the billingDate to set
	 */
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
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
	 * @return the billAmount
	 */
	public Double getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * Overloaded toString method.
	 * 
	 * @return String
	 */
	public String toString() {
		return "Patient Id: " + this.patientId + "First Name: " + this.firstName + ", Last Name: "
		        + this.lastName + ", gender: " + this.gender + "dob: " + this.dob + "phoneNumber: "
		        + this.phoneNumber + "diagnosis: " + this.diagnosis + ", icdCode: " + this.icdCode
		        + ", addressLine1: " + this.addressLine1 + ",addressLine2: " + this.addressLine2 + ", city: "
		        + this.city + "state: " + this.state + "zipCode: " + this.zipCode + "medicines: "
		        + this.medicines + "dosage: " + this.dosage + "billingDate: " + this.billingDate + "billNumber: " + this.billNumber
		        + "billAmount: " + this.billAmount;
	}
}
