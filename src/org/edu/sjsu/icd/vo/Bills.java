package org.edu.sjsu.icd.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container for list of {@link Bill}.
 * 
 * @author Deepti
 */
@XmlRootElement(name = "bills")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bills {

	@XmlElement(name = "bill")
	private List<Bill> bills;

	/**
	 * Add a {@link Bill} object.
	 * @param bill {@link Bill}
	 */
	public void add(Bill bill) {
		if (bills == null) {
			bills = new ArrayList<>();
		}
		bills.add(bill);
	}

	/**
	 * Gets the list of {@link Bill}.
	 * 
	 * @return List of {@link Bill}
	 */
	public List<Bill> getBills() {
		return bills;
	}

	/**
	 * Sets the list of {@link Bill}.
	 * 
	 * @param bills List of {@link Bill}
	 */
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
}
