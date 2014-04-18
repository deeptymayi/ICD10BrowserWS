package org.edu.sjsu.icd.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.edu.sjsu.icd.dao.IDiseaseDAO;
import org.edu.sjsu.icd.dao.SparseMatrix;
import org.edu.sjsu.icd.dao.SparseVector;
import org.edu.sjsu.icd.dao.ST;
import org.edu.sjsu.icd.vo.Disease;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


/**
 * This is the IDiseaseDAO implements which has the code to interact with the
 * table in DB.
 * 
 * @author Deepti
 */
public class GlobalImpl {

	private static JdbcTemplate jdbcTemplate;
	public static SparseMatrix vocabICDSparseMatrix = new SparseMatrix(43029);
	public static Map<String,Integer> getIdFromVocab = new HashMap<String,Integer>();
	public static Map<Integer,String> getDescpFromIcdId = new HashMap<Integer,String>();
	public static Map<Short, Short> vocabhm = new HashMap<Short, Short>();
	public static Map<Integer, Integer> icdhm = new HashMap<Integer, Integer>();
	
	/**
	 * Set the datasource object.
	 * 
	 * @param dataSource
	 *            {@link DataSource}
	 */
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static void generateSparseMatrix() {
		
		String[] descriptionSplitted;
		Integer key;
		String value, word;
		int vocabId = -1;
		int x;
		
		// I - Create Vocab Hash map and ICD hash Map-
		
		// Vocab Hash Map - where key is vocab keyword and value is vocabId  		
		getIdFromVocab = (Map)jdbcTemplate.query("SELECT id,keyword FROM disease_keyword_freq_formatted", new Object[]{},
				new ResultSetExtractor() {
					public Object extractData(ResultSet rs) throws SQLException {
						Map<String,Integer> getIdFromVocab = new HashMap<String,Integer>();
						while (rs.next()) {
							getIdFromVocab.put(rs.getString("keyword"), rs.getInt("id"));
						}
						return getIdFromVocab;
					};
				}
		);
		
		// ICD Hash Map - where key is ICD ID and value is ICD Description
		getDescpFromIcdId = jdbcTemplate.query("SELECT id, icd_code, disease FROM icd_code_to_disease_mapping_formatted order by id", new Object[]{},
				new ResultSetExtractor() {
					public Object extractData(ResultSet rs) throws SQLException {
						Map<Integer,String> getDescpFromIcdId = new HashMap<Integer,String>();
						while (rs.next()) {
							getDescpFromIcdId.put(rs.getInt("id"), rs.getString("disease"));
						}
						return getDescpFromIcdId;
					};
				}
		);		
		System.out.println("Step 1 done");
		
		// II - Populate the frequency Matrix rows - vocab, column - icd
	    
	    Iterator iter = getDescpFromIcdId.keySet().iterator();
	    while(iter.hasNext()) {
	        key = (Integer)iter.next(); // key variable has ICD10 ID
	        value = (String)getDescpFromIcdId.get(key); // value variable has the ICD10 description
	        descriptionSplitted = value.split("\\s"); // Get array of all words from each ICD10 description
	        for (int index=0; index < descriptionSplitted.length ; index++) { 
				word = descriptionSplitted[index].trim().toLowerCase();	// Get each word of ICD10 description
				// Check if word exists in the Vocab dictionary. Vocab dictionary does not include stop words
				vocabId = getIdFromVocab.containsKey(word) ? getIdFromVocab.get(word) : -1; // Vocab id will be -1 in case of stop words
				if(vocabId > 0){
					x = (int) vocabICDSparseMatrix.get(vocabId, key); // get existing freq. for vocabICDSparseMatrix[vocabId][icdId]
					x = x + 1; // increment frequency
					vocabICDSparseMatrix.put(vocabId, key, x); // add the updated frequency at location vocabICDSparseMatrix[vocabId][icdId]
				}
			}	
	    }
	    System.out.println("Step 2 done");

	    //III - Create two hashmap, one with some of columns(icdhm) and other with sum or rows(vocabhm) from freq array
	    
		int sumOfColumn = 0;
		for(int n = 1; n <= 43028; n++){
			for(int m=1; m <= 7072; m++){
				sumOfColumn = (int) (sumOfColumn + vocabICDSparseMatrix.get(m, n));
			}	
			icdhm.put(n, sumOfColumn);
			//System.out.println(n + " - " + sumOfColumn);
			sumOfColumn = 0;
		}
		System.out.println("Step 3 done");
	}
}
