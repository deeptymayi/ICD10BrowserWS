package org.edu.sjsu.icd.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.edu.sjsu.icd.vo.Diseases;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Deepti
 *
 */
public class ObjectJsonBidirectionalConverter {

	/**
	 * Convert the Java object @link {@link Diseases} to JSON string.
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
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
}
