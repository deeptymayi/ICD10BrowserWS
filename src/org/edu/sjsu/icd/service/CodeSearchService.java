/**
 * 
 */
package org.edu.sjsu.icd.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.edu.sjsu.icd.dao.DiseaseDAO;
import org.edu.sjsu.icd.vo.Disease;
import org.edu.sjsu.icd.vo.Diseases;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the service class to manage the data fetch and converting the data to
 * right content type to be set to response.
 * 
 * @author Deepti
 */
public class CodeSearchService {

	/**
	 * Disease DAO object.
	 */
	private DiseaseDAO diseaseDAO;

	/**
	 * Fetches the Disease object based on the ICD code.
	 * 
	 * @param icdCode ICD code
	 * @return Disease detail in XML format.
	 */
	public String fetchDiseaseById(String icdCode) {
		Disease disease = diseaseDAO.findDiseaseByICDCode(icdCode);

		// Create the object to maintain symmetry in XML structure.
		Diseases diseases = new Diseases();
		diseases.add(disease);

		return toJson(diseases);
	}

	/**
	 * Fetches all the diseases which has the said tag.
	 * 
	 * @param tag A keyword to be looked up in all the disease descriptions.
	 * @return Diseases with details in XML format.
	 */
	public String fetchDiseaseByTag(String tag) {
		List<Disease> diseaseList = diseaseDAO.findDiseaseByTag(tag);

		// Create the object to maintain symmetry in XML structure.
		Diseases diseases = new Diseases();
		diseases.setDiseases(diseaseList);

		return toJson(diseases);
	}

	/**
	 * Convert the Java object @link {@link Diseases} to XML string.
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unused")
    private String toXml(Object object) {
		OutputStream outputStream = new ByteArrayOutputStream();

		try {
			Marshaller marshaller = JAXBContext.newInstance(object.getClass()).createMarshaller();
			marshaller.marshal(object, outputStream);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return outputStream.toString();
	}

	/**
	 * Convert the Java object @link {@link Diseases} to JSON string.
	 * 
	 * @param object
	 * @return
	 */
	private String toJson(Object object) {
		OutputStream outputStream = new ByteArrayOutputStream();

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(outputStream, object);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return outputStream.toString();
	}

	/**
	 * Sets the DiseaseDAO object.
	 * 
	 * @param diseaseDAO {@link DiseaseDAO}
	 */
	public void setDiseaseDAO(DiseaseDAO diseaseDAO) {
		this.diseaseDAO = diseaseDAO;
	}
}
