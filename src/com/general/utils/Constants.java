package com.general.utils;

import java.io.Serializable;



import com.general.utils.NoLoggedUserException;


public class Constants implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int ACTIVE = 1;
	public static final String MEMBER_INVALID_EMAIL = "MEMBER_INVALID_EMAIL";
	public static final String MEMBER_INVALID_PASSOWRD = "MEMBER_INVALID_PASSOWRD";
	public static final String EMAIL_ALREADY_EXIST = "EMAIL_ALREADY_EXIST";
	public static final String DATABASE_ERROR_MESSAGE = "DATABASE_ERROR";
	public static final String HOME_PAGE = "home.xhtml"; 
	public static final String USER_ADDED_SUCCESSFULLY = "USER_ADDED_SUCCESSFULLY";
	public static final String ADD_EVENT_EVENT_ADDED_SUCCESSFULLY = "ADD_EVENT_EVENT_ADDED_SUCCESSFULLY";

	public static final CustomException invalidEmail = new CustomException(
			MEMBER_INVALID_EMAIL);
	public static final CustomException invalidPassword = new CustomException(
			MEMBER_INVALID_PASSOWRD);
	public static final CustomException EMAIL_ALREADY_EXISTS = new CustomException(
			EMAIL_ALREADY_EXIST);
	public static final CustomException DATABASE_ERROR = new CustomException(
			DATABASE_ERROR_MESSAGE);
	public static final String REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED = "REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED";
	public static final RuntimeException RUNTIME_EXCEPTION = new RuntimeException();
	

	
}
