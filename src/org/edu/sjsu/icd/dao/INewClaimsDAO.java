package org.edu.sjsu.icd.dao;


/**
 * DAO class responsible for reading and writing new claims to/from the DB
 * table.
 * 
 * @author Deepti
 */
public interface INewClaimsDAO {

	/**
	 * Truncates the old entries and inserts the new entries for last one day.
	 * The data is a join of patient, medicall_bill, medical_record, and icd
	 * table.
	 */
	public void refresh();
}
