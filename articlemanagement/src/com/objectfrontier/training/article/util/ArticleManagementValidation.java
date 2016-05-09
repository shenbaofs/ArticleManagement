package com.objectfrontier.training.article.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.objectfrontier.training.article.model.AppErrorCode;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.User;

public class ArticleManagementValidation {
	
	
	AppErrorCode errorcode = null;
	
	public void validateUserDetails(User user) throws AppException {
	
		if (user.getUsername()== null || user.getUsername().isEmpty()) {
			throw new AppException(AppErrorCode.USER_NAME_NULL);    
		}
		
		if (user.getPassword()   == null || user.getPassword().isEmpty()) { 
			throw new AppException(AppErrorCode.USER_PASSWORD_NULL);  
		}
		
		if (user.getEmailId()   == null || user.getEmailId().isEmpty())	{
			throw new AppException( AppErrorCode.USER_EMAIL_ID_NULL);
		}
		
		phoneNoValidation(user.getPhoneNo());
		dateOfBirthValidation(user.getDateOfBirth());
	}	
	
	final void phoneNoValidation(long PhoneNo) {
	    
		Long phoneno = new Long(PhoneNo);
	    String str = phoneno.toString();
	    if(str.length() < 10 || str.length() > 10) { 
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
		
		if (password   == null || password.isEmpty()) { 
			throw new AppException(AppErrorCode.USER_PASSWORD_NULL);
		}
	}
} 
