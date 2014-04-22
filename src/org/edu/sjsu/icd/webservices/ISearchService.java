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
public interface ISearchService {
	/**
	 * Fetches the list of disease which has the mention of the tagged word in
	 * their description and returns the complete list of Disease names and
	 * their respective ICD10 Codes.
	 * 
	 * @param f tag
	 * @return List of diseases
	 */
	@GET
	@Path("/fetchByTag/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchByTag(@PathParam("f") String f);

	/**
	 * Fetches the disease description and ICD10 code after running text
	 * analytics using Naive-Bayes algorithm. Only 10% of the data with the
	 * highest probability of the tagged word in their description are returned as matches. 
	 * @param f tag
	 * @return List of diseases
	 */
	@GET
	@Path("/fetchByTagTextAnalytics/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchByTagTextAnalytics(@PathParam("f") String f);

}
