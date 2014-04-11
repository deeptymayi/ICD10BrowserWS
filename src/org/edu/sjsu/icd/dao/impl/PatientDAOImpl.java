package org.edu.sjsu.icd.dao.impl;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IPatientDAO;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.dao.EmptyResultDataAccessException;
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
		int result = 0;
		boolean returnValue = false;

		try {
			// Create a query using the JDBC template and insert the record.
			result = jdbcTemplate.update(
			        query,
			        new Object[] { patient.getPatientId(), patient.getFirstName(), patient.getLastName(),
			                patient.getDob(), patient.getGender(), patient.getPhoneNumber(),
			                patient.getAddressLine1(), patient.getAddressLine2(), patient.getCity(),
			                patient.getState(), patient.getZipCode() });
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

	@Override
	public Patient fetchPatientById(String patientId) {

		// Query to retrieve Patient record by the patient id
		String query = "SELECT * FROM PATIENT WHERE PATIENT_ID=?";

		Patient patient = null;

		try {
			// Create a query using the JDBC template and fetch the record.
			patient = jdbcTemplate.queryForObject(query, new Object[] { patientId },
			        new BeanPropertyRowMapper<Patient>(Patient.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		return patient;
	}
}
