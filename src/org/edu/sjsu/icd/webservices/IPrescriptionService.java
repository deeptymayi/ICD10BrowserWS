/**
 * 
 */
package org.edu.sjsu.icd.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.edu.sjsu.icd.vo.Patient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */
public interface IPrescriptionService {
	/**
	 * Saves all Patient, Diagnosis and Medical Billing related information for a unique
	 * Patient with a unique Medical Billing number.
	 * @param patient Patient details
	 * @return Prescription to record success or failure message
	 */
	@POST
	@Path("/pres/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response savePrescription(@RequestBody Patient patient);

}
