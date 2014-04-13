package org.edu.sjsu.icd.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IDiseaseDAO;
import org.edu.sjsu.icd.vo.Disease;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This is the IDiseaseDAO implements which has the code to interact with the
 * table in DB.
 * 
 * @author Deepti
 */
public class DiseaseDAOImpl implements IDiseaseDAO {

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

	/**
	 * Retrieves the ICD code records based on the ICD code.
	 * 
	 * @param icdCode ICD code
	 * @return {@link Disease}
	 */
	public Disease findDiseaseByICDCode(String icdCode) {

		// Query to retrieve ICD code record by the ICD code
		String query = "SELECT * FROM ICD_CODE_TO_DISEASE_MAPPING WHERE ICD_CODE=?";

		Disease disease = null;

		try {
			// Create a query using the JDBC template and fetch the record.
			disease = jdbcTemplate.queryForObject(query, new Object[] { icdCode },
			        new BeanPropertyRowMapper<Disease>(Disease.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		return disease;
	}

	/**
	 * Retrieve the ICD code records based on that tags from the description.
	 * 
	 * @param tag keyword in disease description
	 * @return {@link Disease}
	 */
	public List<Disease> findDiseaseByTag(String tag) {

		List<Disease> diseases = null;

		StringBuilder query = new StringBuilder();
		String[] args = tag.split(" ");

		// Build the query to retrieve ICD code record by tag in the description
		// based on the search field.
		if (args.length > 0) {
			query.append("SELECT * FROM ICD_CODE_TO_DISEASE_MAPPING WHERE DESCRIPTION LIKE '%" + args[0]
			        + "%'");

			// If more than one keyword is given then the query will have
			// multiple where clause.
			for (int i = 1; i < args.length; i++) {
				query.append("AND DESCRIPTION LIKE '%" + args[i] + "%'");
			}

			try {
				diseases = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Disease>(
				        Disease.class));
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				emptyResultDataAccessException.printStackTrace();
			}

		}
		// Create a query using the JDBC template and fetch the records.
		return diseases;
	}

	@Override
	public List<Disease> findDiseaseByTagTextAnalytics(String tag) {
		
		List<Disease> diseases = null;

		/*StringBuilder query = new StringBuilder();
		String[] args = tag.split(" ");

		// Build the query to retrieve ICD code record by tag in the description
		// based on the search field.
		if (args.length > 0) {
			query.append("SELECT * FROM ICD_CODE_TO_DISEASE_MAPPING WHERE DESCRIPTION LIKE '%" + args[0]
			        + "%'");

			// If more than one keyword is given then the query will have
			// multiple where clause.
			for (int i = 1; i < args.length; i++) {
				query.append("AND DESCRIPTION LIKE '%" + args[i] + "%'");
			}

			try {
				diseases = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Disease>(
				        Disease.class));
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				emptyResultDataAccessException.printStackTrace();
			}

		}*/
		// Create a query using the JDBC template and fetch the records.
		return diseases;
	}
}
