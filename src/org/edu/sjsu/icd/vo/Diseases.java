package org.edu.sjsu.icd.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container for list of {@link Disease}.
 * 
 * @author Deepti
 */
@XmlRootElement(name = "diseases")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diseases {

	@XmlElement(name = "disease")
	private List<Disease> diseases;

	/**
	 * Add a {@link Disease} object.
	 * @param disease {@link Disease}
	 */
	public void add(Disease disease) {
		if (diseases == null) {
			diseases = new ArrayList<>();
		}
		diseases.add(disease);
	}

	/**
	 * Gets the list of {@link Disease}.
	 * 
	 * @return List of {@link Disease}
	 */
	public List<Disease> getDiseases() {
		return diseases;
	}

	/**
	 * Sets the list of {@link Disease}.
	 * 
	 * @param diseases List of {@link Disease}
	 */
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
}
