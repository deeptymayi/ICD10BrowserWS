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

import org.edu.sjsu.icd.vo.User;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Deepti
 * 
 */
public interface IAccountServices {
	/**
	 * Client registration/signup.Client enters the first name, last name, a
	 * unique username and password to register for the service.
	 * 
	 * @param user User details
	 * @return registration success or failure details
	 */
	@POST
	@Path("/signup/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response signup(@RequestBody User user);

	/**
	 * 
	 * Client enters a valid username and the correct password and gets
	 * authenticated to be able to use the services.
	 * 
	 * @param user User details
	 * @return authentication success or failure message
	 * 
	 */
	@POST
	@Path("/login/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response login(@RequestBody User user);
}
