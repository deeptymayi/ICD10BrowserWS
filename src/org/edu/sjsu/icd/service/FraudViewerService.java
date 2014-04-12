/**
 * 
 */
package org.edu.sjsu.icd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.edu.sjsu.icd.dao.IFraudBillsDAO;
import org.edu.sjsu.icd.dao.IMedBillDAO;
import org.edu.sjsu.icd.utils.ObjectJsonBidirectionalConverter;
import org.edu.sjsu.icd.vo.Bill;
import org.edu.sjsu.icd.vo.Bills;

/**
 * @author Deepti
 * 
 */
public class FraudViewerService {

	/**
	 * {@link FraudBillsDAO DAO object.
	 */
	private IFraudBillsDAO fraudBillsDAO;

	/**
	 * Medical Bill DAO object.
	 */
	private IMedBillDAO    medBillDAO;

	/**
	 * @param fraudBillsDAO the fraudBillsDAO to set
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
	 * @param i
	 * @return
	 */
	public String fetchBillByNumber(String i) {

		Bill bill = fraudBillsDAO.fetchBillByNumber(i);

		// Create the object to maintain symmetry in XML structure.
		Bills bills = new Bills();
		bills.add(bill);

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
}
