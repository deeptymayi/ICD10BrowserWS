package org.edu.sjsu.icd.dao;

import org.edu.sjsu.icd.vo.Patient;

/**
 * 
 * @author Deepti
 */
public interface IPatientDAO {

	/**
	 * Created a new Patient from the details provided in the doctor's
	 * prescription
	 * 
	 * @param patient Object holding Patient information.
	 * @return true if patient record persistence is successful.
	 */
	public boolean persistPatientInformation(Patient patient);

	/**
	 * Fetch the complete patient record by patient Id.
	 * 
	 * @param patientId Patient id
	 * @return Patient object
	 */
	public Patient fetchPatientById(String patientId);
}
