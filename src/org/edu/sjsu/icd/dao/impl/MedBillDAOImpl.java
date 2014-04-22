/**
 * 
 */
package org.edu.sjsu.icd.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IMedBillDAO;
import org.edu.sjsu.icd.vo.Bill;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		String query = "INSERT INTO MEDICAL_BILL (BILLING_DATE, BILL_NUMBER, ICD10_CODE, BILLING_AMOUNT, CREATE_DATE) VALUES (?, ?, ?, ?, ?)";
		boolean returnValue = false;

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		// Create a query using the JDBC template and insert the record.
		int result = jdbcTemplate.update(query,
		        new Object[] { patient.getBillingDate(), patient.getBillNumber(), patient.getIcdCode(),
		                patient.getBillAmount(), date});

		if (result != 0)
			returnValue = true;

		return returnValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.edu.sjsu.icd.dao.IFraudBillsDAO#fetchFraudBillsByDateRange(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public long fetchTotalNoOfBillsByDateRange(String startDate, String endDate) {
		List<Bill> bills = null;

		String query = "SELECT BILL_NUMBER FROM MEDICAL_BILL WHERE BILLING_DATE >= '" + startDate + "' AND BILLING_DATE <= '" + endDate + "'";

		try {
			bills = jdbcTemplate.query(query, new BeanPropertyRowMapper<Bill>(Bill.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		// Create a query using the JDBC template and fetch the records.
		return bills.size();
	}

}
