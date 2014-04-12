package org.edu.sjsu.icd.dao.impl;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IPatientDAO;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class PatientDAOImpl implements IPatientDAO {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Set the data source object.
	 * 
	 * @param dataSource
	 *            {@link DataSource}
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean persistPatientInformation(Patient patient) {

		// Query to insert Patient information to the Patient DB Table
		String query = "INSERT INTO PATIENT (PATIENT_ID, FIRST_NAME, LAST_NAME, DOB, GENDER, PHONE_NUMBER, ADDRESSLINE_1, ADDRESSLINE_2, CITY, STATE, ZIP_CODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean returnValue = false;

		// Create a query using the JDBC template and insert the record.
		int result = jdbcTemplate.update(
		        query,
		        new Object[] { patient.getPatientId(), patient.getFirstName(), patient.getLastName(),
		                patient.getDob(), patient.getGender(), patient.getPhoneNumber(),
		                patient.getAddressLine1(), patient.getAddressLine2(), patient.getCity(),
		                patient.getState(), patient.getZipCode() });

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

	@Override
	public Patient fetchPatientById(String patientId) {

		// Query to retrieve Patient record by the patient id
		String query = "SELECT * FROM PATIENT WHERE PATIENT_ID=?";

		// Create a query using the JDBC template and fetch the record.
		return jdbcTemplate.queryForObject(query, new Object[] { patientId },
		        new BeanPropertyRowMapper<Patient>(Patient.class));

	}
}
