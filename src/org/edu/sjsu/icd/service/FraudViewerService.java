/**
 * 
 */
package org.edu.sjsu.icd.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.edu.sjsu.icd.dao.IDiseaseDAO;
import org.edu.sjsu.icd.dao.IFraudBillsDAO;
import org.edu.sjsu.icd.dao.IMedBillDAO;
import org.edu.sjsu.icd.dao.INewClaimsDAO;
import org.edu.sjsu.icd.fdmr.FDMapper;
import org.edu.sjsu.icd.fdmr.FDReducer;
import org.edu.sjsu.icd.fdmr.FraudDetectionMRDriver;
import org.edu.sjsu.icd.fdmr.InputWritable;
import org.edu.sjsu.icd.fdmr.OutputWritable;
import org.edu.sjsu.icd.utils.ObjectJsonBidirectionalConverter;
import org.edu.sjsu.icd.vo.Bill;
import org.edu.sjsu.icd.vo.Bills;
import org.edu.sjsu.icd.vo.Disease;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Deepti
 * 
 */
public class FraudViewerService {

	private IFraudBillsDAO fraudBillsDAO;

	private IMedBillDAO    medBillDAO;

	private INewClaimsDAO  newClaimsDAO;

	private IDiseaseDAO    diseaseDAO;

	/**
	 * @param medBillDAO the medBillDAO to set
	 */
	public void setFraudBillsDAO(IFraudBillsDAO fraudBillsDAO) {
		this.fraudBillsDAO = fraudBillsDAO;
	}

	/**
	 * @param medBillDAO the medBillDAO to set
	 */
	public void setMedBillDAO(IMedBillDAO medBillDAO) {
		this.medBillDAO = medBillDAO;
	}

	/**
	 * @param newClaimsDAO the newClaimsDAO to set
	 */
	public void setNewClaimsDAO(INewClaimsDAO newClaimsDAO) {
		this.newClaimsDAO = newClaimsDAO;
	}

	/**
	 * Sets the IDiseaseDAO object.
	 * 
	 * @param diseaseDAO {@link IDiseaseDAO}
	 */
	public void setDiseaseDAO(IDiseaseDAO diseaseDAO) {
		this.diseaseDAO = diseaseDAO;
	}

	/**
	 * @param i
	 * @return
	 */
	public String fetchBillByNumber(String i) {

		Bill bill = fraudBillsDAO.fetchBillByNumber(i);

		// Create the object to maintain symmetry in XML structure.
		Bills bills = new Bills();
		bills.add(bill);

		this.populatePossibleIcdCode(bills);

		return ObjectJsonBidirectionalConverter.toJson(bills);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public String fetchFraudBillsByDateRange(String start, String end) {
		List<Bill> billz = fraudBillsDAO.fetchFraudBillsByDateRange(start, end);

		// Create the object to maintain symmetry in XML structure.
		Bills bills = new Bills();
		bills.setBills(billz);

		return ObjectJsonBidirectionalConverter.toJson(bills);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public String fetchFraudSummaryByDateRange(String start, String end) {
		Map<String, String> summary = new HashMap<String, String>();

		List<Bill> fbillz = fraudBillsDAO.fetchFraudBillsByDateRange(start, end);

		long totalBills = medBillDAO.fetchTotalNoOfBillsByDateRange(start, end);

		summary.put("fraudBills", String.valueOf(fbillz.size()));
		summary.put("totalBills", String.valueOf(totalBills));

		return ObjectJsonBidirectionalConverter.toJson(summary);
	}

	private void populatePossibleIcdCode(Bills bills) {
		Iterator<Bill> i = bills.getBills().iterator();
		while (i.hasNext()) {
			Bill bill = i.next();

			String symptom = bill.getSymptoms();

			if (symptom != null && symptom.trim().length() > 0) {
				List<Disease> diseases = diseaseDAO.findDiseaseByTagTextAnalytics(symptom);

				String s = "";
				for (int j = 0; j < 5 && j < diseases.size(); j++) {
					String s1 = (diseases.get(j)).getIcdCode();
					if (s1 != null && s1.trim().length() > 0) {
						if (!"".equalsIgnoreCase(s)) {
							s = s + ", ";
						}
						s = s + s1;
					}
				}

				bill.setSuggestedIcd(s);
			}
		}
	}

	/**
	 * This cron job will identify the new claim data that will be analyzed for
	 * fraud.
	 */
	@Scheduled(cron = "0 05,15,25,35,45,55 * * * *")
	public void prepareNewClaimsForFraudDetection() {
		System.out.println("Firing the cron for fraud detection.");
		newClaimsDAO.refresh();
	}

	/**
	 * This cron job will trigger the mapreduce for fraud analysis of the new
	 * claims data.
	 * 
	 * @Scheduled(cron = "0 00,10,20,30,40,50 * * * *")	
	 */
	public void runFraudDetectionMRJob() {
		System.out.println("Firing the cron for MR detection job.");
		try {
			Configuration conf = new Configuration();
			DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/icd10_db",
			        "root", "creator123");

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
			DBOutputFormat.setOutput(job, "fraud_bills", new String[] { "bill_number", "first_name",
			        "last_name", "billing_date", "symptoms", "bill_icd" });

			job.waitForCompletion(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
