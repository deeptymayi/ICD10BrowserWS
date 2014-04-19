package org.edu.sjsu.icd.dao.impl;

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
public class DiseaseDAOImpl implements IDiseaseDAO {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Set the datasource object.
	 * 
	 * @param dataSource
	 *            {@link DataSource}
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Retrieves the ICD code records based on the ICD code.
	 * 
	 * @param icdCode ICD code
	 * @return {@link Disease}
	 */
	public Disease findDiseaseByICDCode(String icdCode) {

		// Query to retrieve ICD code record by the ICD code
		String query = "SELECT * FROM ICD_CODE_TO_DISEASE_MAPPING WHERE ICD_CODE=?";

		Disease disease = null;

		try {
			// Create a query using the JDBC template and fetch the record.
			disease = jdbcTemplate.queryForObject(query, new Object[] { icdCode },
			        new BeanPropertyRowMapper<Disease>(Disease.class));
		}
		catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
		}

		return disease;
	}

	/**
	 * Retrieve the ICD code records based on that tags from the description.
	 * 
	 * @param tag keyword in disease description
	 * @return {@link Disease}
	 */
	public List<Disease> findDiseaseByTag(String tag) {

		List<Disease> diseases = null;

		StringBuilder query = new StringBuilder();
		String[] args = tag.split(" ");

		// Build the query to retrieve ICD code record by tag in the description
		// based on the search field.
		if (args.length > 0) {
			query.append("SELECT * FROM ICD_CODE_TO_DISEASE_MAPPING WHERE DESCRIPTION LIKE '%" + args[0]
			        + "%'");

			// If more than one keyword is given then the query will have
			// multiple where clause.
			for (int i = 1; i < args.length; i++) {
				query.append("AND DESCRIPTION LIKE '%" + args[i] + "%'");
			}

			try {
				diseases = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Disease>(
				        Disease.class));
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				emptyResultDataAccessException.printStackTrace();
			}

		}
		// Create a query using the JDBC template and fetch the records.
		return diseases;
	}

	@SuppressWarnings("null")
	@Override
	public List<Disease> findDiseaseByTagTextAnalytics(String tag) {
		
		List<Disease> diseases = new ArrayList<Disease>();
		int vocabLength = 7072; //TODO : change get from db
		//Map<String,Integer> getIdFromVocab = new HashMap<String,Integer>();
		//Map<Integer,String> getDescpFromIcdId = new HashMap<Integer,String>();
		//Map<Short, Short> vocabhm = new HashMap<Short, Short>();
		//Map<Integer, Integer> icdhm = new HashMap<Integer, Integer>();
		//SparseMatrix vocabICDSparseMatrix = new SparseMatrix(43029);
		String[] textByUserArr;
		ArrayList<Integer> candidateSet = new ArrayList<Integer>();
		Map<Integer,Double> unsortedResultMap = new HashMap<Integer,Double>();
		int x;
		double temp =0;
		double numerator = 0;
		double denominator = 0;
		double division = 0;
		
		/*// I - Create Vocab Hash map and ICD hash Map-
		
		// Vocab Hash Map - where key is vocab keyword and value is vocabId  		
		SparseMatrixBuilderDAO.getIdFromVocab = (Map)jdbcTemplate.query("SELECT id,keyword FROM disease_keyword_freq_formatted", new Object[]{},
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
		SparseMatrixBuilderDAO.getDescpFromIcdId = jdbcTemplate.query("SELECT id, icd_code, disease FROM icd_code_to_disease_mapping_formatted order by id", new Object[]{},
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
	    
	    Iterator iter = SparseMatrixBuilderDAO.getDescpFromIcdId.keySet().iterator();
	    while(iter.hasNext()) {
	        key = (Integer)iter.next(); // key variable has ICD10 ID
	        value = (String)SparseMatrixBuilderDAO.getDescpFromIcdId.get(key); // value variable has the ICD10 description
	        descriptionSplitted = value.split("\\s"); // Get array of all words from each ICD10 description
	        for (int index=0; index < descriptionSplitted.length ; index++) { 
				word = descriptionSplitted[index].trim().toLowerCase();	// Get each word of ICD10 description
				// Check if word exists in the Vocab dictionary. Vocab dictionary does not include stop words
				vocabId = SparseMatrixBuilderDAO.getIdFromVocab.containsKey(word) ? SparseMatrixBuilderDAO.getIdFromVocab.get(word) : -1; // Vocab id will be -1 in case of stop words
				if(vocabId > 0){
					x = (int) SparseMatrixBuilderDAO.vocabICDSparseMatrix.get(vocabId, key); // get existing freq. for vocabICDSparseMatrix[vocabId][icdId]
					x = x + 1; // increment frequency
					SparseMatrixBuilderDAO.vocabICDSparseMatrix.put(vocabId, key, x); // add the updated frequency at location vocabICDSparseMatrix[vocabId][icdId]
				}
			}	
	    }
	    System.out.println("Step 2 done");

	    //III - Create two hashmap, one with some of columns(icdhm) and other with sum or rows(vocabhm) from freq array
	    
		int sumOfRow = 0;
		for(int m=1; m <= 7072; m++){
			for(int n = 1; n <= 43028; n++){
				sumOfRow = (int) (sumOfRow + vocabICDSparseMatrix.get(m, n));
			}
			vocabhm.put((short)m, (short)sumOfRow);
			//System.out.println(m + " - " + sumOfRow);
			sumOfRow = 0;
		}		
		
		int sumOfColumn = 0;
		for(int n = 1; n <= 43028; n++){
			for(int m=1; m <= 7072; m++){
				sumOfColumn = (int) (sumOfColumn + SparseMatrixBuilderDAO.vocabICDSparseMatrix.get(m, n));
			}	
			SparseMatrixBuilderDAO.icdhm.put(n, sumOfColumn);
			//System.out.println(n + " - " + sumOfColumn);
			sumOfColumn = 0;
		}
		System.out.println("Step 3 done");*/
		
		//IV - Creating candidate set for the input by user
		// Candidate set has all the probable icd codes possible for the input search criteria by the user
				
		textByUserArr = tag.split("\\s");
		for(int index=0; index < textByUserArr.length; index++){			
			candidateSet = jdbcTemplate.query("SELECT id FROM ICD_CODE_TO_DISEASE_MAPPING_FORMATTED WHERE DISEASE LIKE '%" + textByUserArr[index].trim().toLowerCase() + "%'", new Object[]{},
					new ResultSetExtractor() {
						public Object extractData(ResultSet rs) throws SQLException {
							ArrayList<Integer> candidateSet = new ArrayList<Integer>();
							while (rs.next()) {
								candidateSet.add(rs.getInt("id"));
							}
							return candidateSet;
						};
					}
			);	
		}
		
		// For each of the ICD10 codes in the candidate set find the logarithmic probability for each icd10 code being the most accurate resultset
		for (Integer y : candidateSet){ // y is the icdId
			//System.out.println(y);
			for(int index=0; index < textByUserArr.length; index++){
				if(SparseMatrixBuilderDAO.getIdFromVocab.containsKey(textByUserArr[index].trim().toLowerCase())){
					numerator = SparseMatrixBuilderDAO.vocabICDSparseMatrix.get(SparseMatrixBuilderDAO.getIdFromVocab.get(textByUserArr[index].trim().toLowerCase()),y) + 1;
					denominator = vocabLength + SparseMatrixBuilderDAO.icdhm.get(y);
					division = numerator/denominator;
					temp = temp + Math.log10(numerator/denominator);
				}
			}
			if(temp != 0){
				unsortedResultMap.put(y, temp);
			}
			temp = 0;
		}
		
		// Sort the result with the most recent result at the top
		Map<Integer,Double> sortedResultMap = sortByComparator(unsortedResultMap);
		
		// Return only the top 10% results 
		int size = (int) (0.10 *  sortedResultMap.size());
		int noOfResults = 0;
		String icdCode, icdDescription;
		
		for (Map.Entry entry : sortedResultMap.entrySet()) {
			if(noOfResults < size){
				icdCode = (String)jdbcTemplate.queryForObject("SELECT icd_code FROM icd_code_to_disease_mapping_formatted WHERE id = ?", new Object[] { entry.getKey() }, String.class);
				icdDescription = SparseMatrixBuilderDAO.getDescpFromIcdId.get(entry.getKey());
				diseases.add(new Disease(icdCode, icdDescription));
				//System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue() + getDescpFromIcdId.get(entry.getKey()));
			}
			noOfResults++;
		}
				
		System.out.println("Step 4 done");
		
		/*for (Disease s : diseases){
			System.out.println(s.getIcdCode()+ " - " +s.getDescription());
		}*/
		    	
		return diseases;
	}
	
	private static Map sortByComparator(Map unsortMap) {
		 
		List list = new LinkedList(unsortMap.entrySet());
 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());			
		}
		return sortedMap;
	}
}
