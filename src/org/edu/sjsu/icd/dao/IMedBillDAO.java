package org.edu.sjsu.icd.dao;

import org.edu.sjsu.icd.vo.Patient;

/**
 * @author Deepti
 * 
 */
public interface IMedBillDAO {

	/**
	 * Insert Patient bill information provided in the doctor's
	 * prescription
	 * 
	 * @param patient Object holding Patient information.
	 * @return true if bill record persistence is successful.
	 */
	public boolean persistBillInformation(Patient patient);
}
