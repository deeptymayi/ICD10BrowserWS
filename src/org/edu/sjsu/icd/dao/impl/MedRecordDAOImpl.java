/**
 * 
 */
package org.edu.sjsu.icd.dao.impl;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IMedRecordDAO;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class MedRecordDAOImpl implements IMedRecordDAO {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.edu.sjsu.icd.dao.IMedRecordDAO#persistMedRecord(org.edu.sjsu.icd.
	 * vo.Patient)
	 */
	@Override
	public boolean persistMedRecord(Patient patient) {
		// Query to insert Patient Diagnosis information to the Medical_Record
		// DB Table
		String query = "insert into medical_record (patient_id, bill_number, diagnosis, icd10_code, medicines, dosage) values (?, ?, ?, ?, ?, ?)";
		boolean returnValue = false;

		// Create a query using the JDBC template and insert the record.
		int result = jdbcTemplate.update(query,
		        new Object[] { patient.getPatientId(), patient.getBillNumber(), patient.getDiagnosis(),
		                patient.getIcdCode(), patient.getMedicines(), patient.getDosage() });

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

}
