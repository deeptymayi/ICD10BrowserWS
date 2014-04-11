package org.edu.sjsu.icd.service;

import org.edu.sjsu.icd.dao.IMedBillDAO;
import org.edu.sjsu.icd.dao.IMedRecordDAO;
import org.edu.sjsu.icd.dao.IPatientDAO;
import org.edu.sjsu.icd.vo.Patient;

/**
 * 
 * 
 * @author Deepti
 */
public class PrescriptionManagementService {

	/**
	 * Patient DAO object.
	 */
	private IPatientDAO   patientDAO;

	/**
	 * Medical Bill DAO object.
	 */
	private IMedBillDAO   medBillDAO;

	/**
	 * Med Record DAO object.
	 */
	private IMedRecordDAO medRecordDAO;

	/**
	 * 
	 * 
	 */
	public boolean persistPatientInformation(Patient patient) {

		try {
			// Check if the patient record already exists. We do not want to
			// insert the bio if the patient Id already exists. Also, we want to
			// use the same patient id for all the bills that belong to this
			// patient.
			String patientId = buildUniquePatientId(patient);
			Patient patient1 = patientDAO.fetchPatientById(patientId);

			if (patient1 == null) {
				patient.setPatientId(patientId);
				patientDAO.persistPatientInformation(patient);
			}
			else {
				patient.setPatientId(patient1.getPatientId());
			}

			medBillDAO.persistBillInformation(patient);
			medRecordDAO.persistMedRecord(patient);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	private String buildUniquePatientId(Patient patient) {
		StringBuilder sb = new StringBuilder();
		sb.append(patient.getFirstName());
		sb.append("::");
		sb.append(patient.getLastName());
		sb.append("::");
		sb.append(patient.getZipCode());

		return sb.toString();
	}

	/**
	 * Sets the IPatientDAO object.
	 * 
	 * @param patientDAO {@link IPatientDAO}
	 */
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	/**
	 * @param medBillDAO the medBillDAO to set
	 */
	public void setMedBillDAO(IMedBillDAO medBillDAO) {
		this.medBillDAO = medBillDAO;
	}

	/**
	 * @param medRecordDAO the medRecordDAO to set
	 */
	public void setMedRecordDAO(IMedRecordDAO medRecordDAO) {
		this.medRecordDAO = medRecordDAO;
	}

}
