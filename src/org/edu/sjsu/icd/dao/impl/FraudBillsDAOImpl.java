/**
 * 
 */
package org.edu.sjsu.icd.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IFraudBillsDAO;
import org.edu.sjsu.icd.vo.Bill;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class FraudBillsDAOImpl implements IFraudBillsDAO {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Set the datasource object.
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
	 * org.edu.sjsu.icd.dao.IFraudBillsDAO#fetchBillByNumber(java.lang.String)
	 */
	@Override
	public Bill fetchBillByNumber(String billNumber) {
		// Query to retrieve fraud bill record by the bill number
		String query = "SELECT * FROM FRAUD_BILLS WHERE BILL_NUMBER=?";

		Bill bill = null;

		try {
			// Create a query using the JDBC template and fetch the record.
			bill = jdbcTemplate.queryForObject(query, new Object[] { billNumber },
			        new BeanPropertyRowMapper<Bill>(Bill.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		return bill;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.edu.sjsu.icd.dao.IFraudBillsDAO#fetchFraudBillsByDateRange(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<Bill> fetchFraudBillsByDateRange(String startDate, String endDate) {
		List<Bill> bills = null;

		String query = "SELECT BILL_NUMBER, FIRST_NAME, LAST_NAME, BILLING_DATE FROM FRAUD_BILLS WHERE BILLING_DATE >= '"
		        + startDate + "' AND BILLING_DATE <= '" + endDate + "'";

		try {
			bills = jdbcTemplate.query(query, new BeanPropertyRowMapper<Bill>(Bill.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		// Create a query using the JDBC template and fetch the records.
		return bills;
	}
}
