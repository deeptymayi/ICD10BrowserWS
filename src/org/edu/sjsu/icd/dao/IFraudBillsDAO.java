/**
 * 
 */
package org.edu.sjsu.icd.dao;

import java.util.List;

import org.edu.sjsu.icd.vo.Bill;

/**
 * @author Deepti
 * 
 */
public interface IFraudBillsDAO {

	/**
	 */
	public Bill fetchBillByNumber(String billNumber);

	/**
	 */
	public List<Bill> fetchFraudBillsByDateRange(String startDate, String endDate);
}
