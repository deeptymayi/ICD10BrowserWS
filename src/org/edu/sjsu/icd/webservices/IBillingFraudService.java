/**
 * 
 */
package org.edu.sjsu.icd.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */

public interface IBillingFraudService {
	/**
	 * Returns the details of a medical bill from the unique bill number.
	 * 
	 * @param i icd code
	 * @return icd details
	 */
	@GET
	@Path("/fetchById/{i}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchBillByNumber(@PathParam("i") String i);

	/**
	 * Fetches all the fraudulent medical bills in a given range of
	 * dates after running text analytics in map and reduce function. Returns
	 * the count of total number of fraudulent bills, Patient firstname, Patient
	 * last name and the medical bill numbers.
	 * 
	 * @param f date range
	 * @return Patient firstname, Patient last name and the medical bill numbers
	 */
	@GET
	@Path("/fetchByRange/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchFraudBillsByDateRange(@PathParam("f") String f);

	/**
	 * Fetches the details of the fraud identified on a given medical bill.
	 * Returns diagnosis description, billing date, billed ICD10 Code
	 * and the Possible ICD10 Code.
	 * 
	 * @param f Fraud summary by date range
	 * @return diagnosis description, billing date, billed ICD10 Code, Possible ICD10 Code
	 */
	@GET
	@Path("/fetchSummaryForRange/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchFraudSummaryByDateRange(@PathParam("f") String f);

}
