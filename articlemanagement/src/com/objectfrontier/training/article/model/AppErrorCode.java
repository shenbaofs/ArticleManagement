package com.objectfrontier.training.article.model;

public enum AppErrorCode {

	USER_NAME_NULL(101, "username is required"), 
	USER_PASSWORD_NULL(102, "password is required"), 
	USER_EMAIL_ID_NULL(103, "email id is required"), 
	INVALID_PHONE_NO(104, "invalid phone number"),
	INVALID_DATE_OF_BIRTH(105, "user should be within 18 to 100 years"), 
	USER_NAME_ALREADY_EXISTS(106, "user already exists"),
	INVALID_LOGIN_CREDENTIALS(107, "invalid username and password"),
	USER_NOT_FOUND(108, "user details not found"), 
	UNAUTHORIZED_OPERATION(109, "unathorized opeation"), 
	PASSWORD_ALREADY_EXISTS(110, "password already exists"), 
	USER_DETAILS_NOT_UPDATED(111, "user details not updated"),
	WAITING_FOR_APPROVAL_CONTACT_ADMIN(112, "waiting for approval contact admin"), 
	USER_STATUS_NOT_UPDATED(113, "status not updated"), 
	AUTHOR_NOT_FOUND(114,"author details not found"), ARTICLE_NOT_FOUND(115, "article details not found");
	
	private final int code;
    private final String message;	
	
    AppErrorCode(int code, String message) {
		 this.code = code;
		 this.message = message;
	}
	
	public int 	getCode() {
        return this.code;
    }
    
	public String getMessage() {
        return this.message;
    }
}

	


