package com.objectfrontier.training.article.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.objectfrontier.training.article.model.AppErrorCode;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.User;

public class ArticleManagementValidation {
	
	AppErrorCode errorcode = null;
	String PASSWORD_PATTERN =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	public void validateUserDetails(User user) throws AppException {
	
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new AppException(AppErrorCode.USER_NAME_NULL);    
		}
		
		if (user.getPassword() == null || user.getPassword().isEmpty() || 
				(!(user.getPassword().matches(PASSWORD_PATTERN)))) { 
			throw new AppException(AppErrorCode.PASSWORD_PATTERN_NOT_MATCHES);  
		}
		
		if (user.getEmailId() == null || user.getEmailId().isEmpty())	{
			throw new AppException( AppErrorCode.USER_EMAIL_ID_NULL);
		}
		
		phoneNoValidation(user.getPhoneNo());
		dateOfBirthValidation(user.getDateOfBirth());
	}	
	
	final void phoneNoValidation(long PhoneNo) {
	    
		Long phoneno = new Long(PhoneNo);
	    String phonenoString = phoneno.toString();
	    if(phonenoString.length() < 10 || phonenoString.length() > 10) { 
	    	throw new AppException(AppErrorCode.INVALID_PHONE_NO);
	    }
	}
	
	final void dateOfBirthValidation(Date dateOfBirth) {
		
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar dob = new GregorianCalendar();
		dob.setTime(dateOfBirth);
		int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if ((dob.get(Calendar.MONTH) >= now.get(Calendar.MONTH))) {
		        	if(dob.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)) {
		        		age--;
		        	}
		 }
	     if (age < 18 || age > 100) { 
	    	 throw new AppException(AppErrorCode.INVALID_DATE_OF_BIRTH);
	     }
	     
	}
	
	public void validateUserDetailsForLogin(String username, String password) {
		
		if (username== null || username.isEmpty()) {
			throw new AppException(AppErrorCode.USER_NAME_NULL);
		}
		
		if (password == null ||password.isEmpty() || 
				(!(password.matches(PASSWORD_PATTERN)))) { 
			throw new AppException(AppErrorCode.PASSWORD_PATTERN_NOT_MATCHES);  
		}
	}
} 
