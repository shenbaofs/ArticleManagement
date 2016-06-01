package com.objectfrontier.training.article.model;

import java.util.Date;

public class User {
	
	private long id;
	private String  username;
	private String  password;
	private String  emailId;
	private long    phoneNo;
	private Date    dateOfBirth;
	private String  gender;
	private String  role;
	private String  status;
	
	public User() {}
	
	public User(long id) {
		
		this.id = id;
	}
	
	public User(long id, String password, long phoneNo) {
		
		this.id = id;
		this.password = password;
		this.phoneNo  = phoneNo;
	}


	public User(String username, String password, String emailId, long phoneNo, Date dateOfBirth, 
			    String gender, String role, String status) {
		
		this.username      = username;
		this.password      = password;
		this.emailId       = emailId;
		this.phoneNo       = phoneNo;
		this.dateOfBirth   = dateOfBirth;
	    this.gender        = gender;
	    this.role          = role;
	    this.status        = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() { 
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
}
	