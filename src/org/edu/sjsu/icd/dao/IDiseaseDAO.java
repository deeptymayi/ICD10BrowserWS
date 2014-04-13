package org.edu.sjsu.icd.dao;

import java.util.List;

import org.edu.sjsu.icd.vo.Disease;

/**
 * DAO class responsible for reading disease information for the DB table.
 * 
 * @author Deepti
 */
public interface IDiseaseDAO {

	/**
	 * Retrieve the disease information using the ICD code.
	 * 
	 * @param icdCode The ICD code of the disease.
	 * @return Disease
	 */
	public Disease findDiseaseByICDCode(String icdCode);

	/**
	 * Retrieve the list of diseases from the tag.
	 * 
	 * @param tag Tag is a keyword in the description.
	 * @return List of diseases
	 */
	public List<Disease> findDiseaseByTag(String tag);
	
	/**
	 * Retrieve the list of diseases from the tag.
	 * 
	 * @param tag Tag is a keyword in the description.
	 * @return List of diseases
	 */
	public List<Disease> findDiseaseByTagTextAnalytics(String tag);
}