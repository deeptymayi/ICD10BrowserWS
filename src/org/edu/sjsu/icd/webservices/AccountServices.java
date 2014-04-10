package org.edu.sjsu.icd.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.edu.sjsu.icd.service.AuthenticationService;
import org.edu.sjsu.icd.utils.ICDAppConstants;
import org.edu.sjsu.icd.vo.User;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */
@Path("accountservice")
public class AccountServices {

	private AuthenticationService authenticationService;

	/**
	 * Client registration/signup.
	 * 
	 * @param user User details
	 * @return disease details
	 */
	@POST 
	@Path("/signup/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response signup(@RequestBody User user) {
		System.out.println(user);
		boolean persisted = authenticationService.signup(user);

		// Respond to the client once the record is published.
		Response response = null;
		if (persisted) {
			response = Response.status(Response.Status.OK).entity(ICDAppConstants.SIGNUP_SUCCESS_RESPONSE_BODY).build();
		}
		else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ICDAppConstants.SIGNUP_FAILURE_RESPONSE_BODY).build();
		}
		return response;
	}

	/**
	 *
	 */
	@POST
	@Path("/login/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response login(@RequestBody User user) {
		String userDetails = authenticationService.login(user.getUserName(), user.getPassword());

		// Respond to the client once the record is published.
		Response response = null;
		if (userDetails != null) {
			response = Response.status(Response.Status.OK).entity(ICDAppConstants.AUTH_SUCCESS_RESPONSE_BODY).build();
		}
		else {
			response = Response.status(Response.Status.UNAUTHORIZED).entity(ICDAppConstants.AUTH_FAILURE_RESPONSE_BODY).build();
		}
		return response;
	}

	/**
	 * Sets the service instance.
	 * 
	 * @param authenticationService service class instance
	 */
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
}
