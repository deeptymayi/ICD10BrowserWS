package org.edu.sjsu.icd.fdmr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

/**
 * @author Deepti
 * 
 */
public class InputWritable implements Writable, DBWritable {
	private String patientId;
	private String firstName;
	private String lastName;
	private int    billNumber;
	private String diagnosis;
	private String billedIcdCode;
	private long   billingDate;
	private String masterIcdCode;
	private String icdDescription;

	public void readFields(DataInput in) throws IOException {
	}

	public void readFields(ResultSet rs) throws SQLException {
		patientId = rs.getString(1);
		firstName = rs.getString(2);
		lastName = rs.getString(3);
		billNumber = rs.getInt(4);
		diagnosis = rs.getString(5);
		billedIcdCode = rs.getString(6);
		billingDate = rs.getDate(7).getTime();
		masterIcdCode = rs.getString(8);
		icdDescription = rs.getString(9);
	}

	public void write(DataOutput out) throws IOException {
	}

	public void write(PreparedStatement ps) throws SQLException {
		// ps.setInt(1, id);
		// ps.setString(2, name);
	}

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the billNumber
	 */
	public int getBillNumber() {
		return billNumber;
	}

	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @return the billedIcdCode
	 */
	public String getBilledIcdCode() {
		return billedIcdCode;
	}

	/**
	 * @return the billingDate
	 */
	public Long getBillingDate() {
		return billingDate;
	}

	/**
	 * @return the masterIcdCode
	 */
	public String getMasterIcdCode() {
		return masterIcdCode;
	}

	/**
	 * @return the icdDescription
	 */
	public String getIcdDescription() {
		return icdDescription;
	}
}