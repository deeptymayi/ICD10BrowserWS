/**
 * 
 */
package org.edu.sjsu.icd.dao.impl;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IMedBillDAO;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class MedBillDAOImpl implements IMedBillDAO {

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
	 * org.edu.sjsu.icd.dao.IMedBillDAO#persistBillInformation(org.edu.sjsu.
	 * icd.vo.Patient)
	 */
	@Override
	public boolean persistBillInformation(Patient patient) {
		// Query to insert Billing information to the Billing_record DB Table
		String query = "INSERT INTO MEDICAL_BILL (BILLING_DATE, BILL_NUMBER, ICD10_CODE, BILLING_AMOUNT) VALUES (?, ?, ?, ?)";
		boolean returnValue = false;

		// Create a query using the JDBC template and insert the record.
		int result = jdbcTemplate.update(query,
		        new Object[] { patient.getBillingDate(), patient.getBillNumber(), patient.getIcdCode(),
		                patient.getBillAmount() });

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

}
