package org.edu.sjsu.icd.utils;

public interface ICDAppConstants {
	public static final String SIGNUP_SUCCESS_RESPONSE_BODY = "{\"success\" : true, \"message\": \"Registration Successful\"}";
	public static final String SIGNUP_FAILURE_RESPONSE_BODY = "{\"success\" : false, \"message\" : \"User already exists\"}";
	public static final String AUTH_SUCCESS_RESPONSE_BODY = "{\"success\" : true, \"message\": \"Login Successful. You will be directed to the Search ICD Page\"}";
	public static final String AUTH_FAILURE_RESPONSE_BODY = "{\"success\" : false, \"message\" : \"Login Failed. Please verify username / password\"}";
}
