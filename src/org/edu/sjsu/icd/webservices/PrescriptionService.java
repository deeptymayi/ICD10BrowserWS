package org.edu.sjsu.icd.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.edu.sjsu.icd.service.PrescriptionManagementService;
import org.edu.sjsu.icd.vo.Patient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */
@Path("ptrservice")
public class PrescriptionService {
	private PrescriptionManagementService prescriptionManagementService;

	/**
	 * @param patient
	 * @return
	 * 
	 */
	@POST
	@Path("/pres/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response savePrescription(@RequestBody Patient patient) {
		boolean prescriptionPersisted = prescriptionManagementService.persistPatientInformation(patient);

		// Respond to the client once the record is published.
		Response response = null;
		if (prescriptionPersisted) {
			response = Response.status(Response.Status.OK).build();
		}
		else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	/**
	 * Sets the service instance.
	 * 
	 * @param prescriptionManagementService service class instance
	 */
	public void setPrescriptionManagementService(PrescriptionManagementService prescriptionManagementService) {
		this.prescriptionManagementService = prescriptionManagementService;
	}
}
