package org.edu.sjsu.icd.fdmr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;

/**
 * @author Deepti
 * 
 */
public class FraudDetectionMRDriver {
	
	/**
	 * @param args a
	 * @throws Exception e
	 */
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ICD10",
		        "root", "destiny");

		Job job = new Job(conf);
		job.setJarByClass(FraudDetectionMRDriver.class);
		job.setMapperClass(FDMapper.class);
		job.setReducerClass(FDReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(OutputWritable.class);
		job.setOutputValueClass(NullWritable.class);
		job.setInputFormatClass(DBInputFormat.class);
		job.setOutputFormatClass(DBOutputFormat.class);

		DBInputFormat.setInput(job, InputWritable.class, "new_claims", null, null, new String[] {
		        "patient_id", "first_name", "last_name", "bill_number", "diagnosis", "billed_icd_code",
		        "billing_date", "master_icd_code", "icd_description" });
		DBOutputFormat.setOutput(job, "fraud_bills", new String[] { "bill_number", "first_name", "last_name",
		        "billing_date", "symptoms", "bill_icd" });

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}