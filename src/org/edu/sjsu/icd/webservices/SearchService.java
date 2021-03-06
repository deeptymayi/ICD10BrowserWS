package org.edu.sjsu.icd.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.edu.sjsu.icd.service.CodeSearchService;

/**
 * RESTful Service class which has the API methods to be invoked by the clients.
 * 
 * @author Deepti
 */
@Path("icdservice")
public class SearchService implements ISearchService {

	private CodeSearchService codeSearchService;

	/**
	 * Fetches disease details based on the ICD code.
	 * 
	 * @param i ICD code
	 * @return disease details
	 */
	@GET
	@Path("/fetchById/{i}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchById(@PathParam("i") String i) {
		return codeSearchService.fetchDiseaseById(i);
	}

	/**
	 * Fetches the list of disease which has the mention of the tagged word in
	 * their description.
	 * 
	 * @param f tag
	 * @return List of diseases
	 */
	@GET
	@Path("/fetchByTag/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchByTag(@PathParam("f") String f) {
		return codeSearchService.fetchDiseaseByTag(f);
	}

	/**
	 * Fetches the list of disease which has the mention of the tagged word in
	 * their description.
	 * 
	 * @param f tag
	 * @return List of diseases
	 */
	@GET
	@Path("/fetchByTagTextAnalytics/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchByTagTextAnalytics(@PathParam("f") String f) {
		return codeSearchService.fetchDiseaseByTagTextAnalytics(f);
	}

	/**
	 * Sets the service instance.
	 * 
	 * @param codeSearchService service class instance
	 */
	public void setCodeSearchService(CodeSearchService codeSearchService) {
		this.codeSearchService = codeSearchService;
	}
}