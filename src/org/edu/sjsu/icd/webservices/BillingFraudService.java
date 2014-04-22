package org.edu.sjsu.icd.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.edu.sjsu.icd.service.FraudViewerService;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */
@Path("bfr")
public class BillingFraudService implements IBillingFraudService {

	private FraudViewerService fraudViewerService;

	/**
	 * 
	 */
	@GET
	@Path("/fetchById/{i}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchBillByNumber(@PathParam("i") String i) {
		return fraudViewerService.fetchBillByNumber(i);
	}

	/**
	 * 
	 */
	@GET
	@Path("/fetchByRange/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchFraudBillsByDateRange(@PathParam("f") String f) {
		String[] range = f.split("_");
		return fraudViewerService.fetchFraudBillsByDateRange(range[0], range[1]);
	}

	/**
	 * 
	 */
	@GET
	@Path("/fetchSummaryForRange/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchFraudSummaryByDateRange(@PathParam("f") String f) {
		String[] range = f.split("_");
		return fraudViewerService.fetchFraudSummaryByDateRange(range[0], range[1]);
	}
	
	/**
	 * Sets the service instance.
	 * 
	 * @param fraudViewerService service class instance
	 */
	public void setFraudViewerService(FraudViewerService fraudViewerService) {
		this.fraudViewerService = fraudViewerService;
	}
}