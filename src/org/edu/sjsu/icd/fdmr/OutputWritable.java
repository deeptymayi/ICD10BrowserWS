package org.edu.sjsu.icd.fdmr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

/**
 * @author Deepti
 *
 */
public class OutputWritable implements Writable, DBWritable {
	private String firstName;
	private String lastName;
	private int    billNumber;
	private String diagnosis;
	private String billedIcdCode;
	private Date   billingDate;

	@SuppressWarnings("javadoc")
    public OutputWritable(int billNumber, String firstName, String lastName, String diagnosis,
	        String billedIcdCode, Date billingDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.billNumber = billNumber;
		this.diagnosis = diagnosis;
		this.billedIcdCode = billedIcdCode;
		this.billingDate = billingDate;
	}

	public void readFields(DataInput in) throws IOException {

	}

	public void readFields(ResultSet rs) throws SQLException {
		// name = rs.getString(1);
		// count = rs.getInt(2);
	}

	public void write(DataOutput out) throws IOException {
	}

	public void write(PreparedStatement ps) throws SQLException {
		ps.setInt(1, billNumber);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setDate(4, billingDate);
		ps.setString(5, diagnosis);
		ps.setString(6, billedIcdCode);
	}
}
