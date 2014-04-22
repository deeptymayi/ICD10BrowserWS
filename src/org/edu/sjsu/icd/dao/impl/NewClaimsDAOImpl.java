package org.edu.sjsu.icd.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.INewClaimsDAO;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Deepti
 * 
 */
public class NewClaimsDAOImpl implements INewClaimsDAO {

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

	@Override
	public void refresh() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());

		// Query to insert Patient information to the Patient DB Table
		String query1 = "TRUNCATE new_claims";
		String query2 = "INSERT INTO NEW_CLAIMS (patient_Id, first_name, last_name, bill_number, "
		        + "diagnosis, billed_icd_code, billing_date, master_icd_code, icd_description) "
		        + "SELECT p.patient_Id, p.first_name, p.last_name, mr.bill_number, mr.diagnosis, "
		        + "mr.icd10_code, mb.billing_date, icd.icd_code, icd.description FROM patient p "
		        + "LEFT JOIN medical_record mr ON mr.patient_id = p.patient_id LEFT JOIN medical_bill mb "
		        + "ON mb.bill_number = mr.bill_number LEFT JOIN icd_code_to_disease_mapping icd "
		        + "ON mb.icd10_code = icd.icd_code WHERE mr.bill_number IS NOT NULL AND mb.billing_date IS NOT NULL "
		        + "AND mr.diagnosis is NOT NULL AND mr.icd10_code is NOT NULL AND create_date > '" + date
		        + "'";

		// Create a query using the JDBC template and insert the record.
		jdbcTemplate.execute(query1);

		System.out.println("Trucated the NEW_CLAIMS table.");

		jdbcTemplate.execute(query2);

		System.out.println("Populated the NEW_CLAIMS table with new claims entered yesterday (" + date + ")");
	}
}
