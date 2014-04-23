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
		String query1 = "truncate new_claims";
		String query2 = "insert into new_claims (patient_id, first_name, last_name, bill_number, "
		        + "diagnosis, billed_icd_code, billing_date, master_icd_code, icd_description) "
		        + "select p.patient_id, p.first_name, p.last_name, mr.bill_number, mr.diagnosis, "
		        + "mr.icd10_code, mb.billing_date, icd.icd_code, icd.description from patient p "
		        + "left join medical_record mr on mr.patient_id = p.patient_id left join medical_bill mb "
		        + "on mb.bill_number = mr.bill_number left join icd_code_to_disease_mapping icd "
		        + "on mb.icd10_code = icd.icd_code where mr.bill_number is not null and mb.billing_date is not null "
		        + "and mr.diagnosis is not null and mr.icd10_code is not null and create_date > '" + date
		        + "'";

		// Create a query using the JDBC template and insert the record.
		jdbcTemplate.execute(query1);

		System.out.println("Trucated the NEW_CLAIMS table.");

		jdbcTemplate.execute(query2);

		System.out.println("Populated the NEW_CLAIMS table with new claims entered yesterday (" + date + ")");
	}
}
