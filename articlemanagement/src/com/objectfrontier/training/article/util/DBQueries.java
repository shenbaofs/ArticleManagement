package com.objectfrontier.training.article.util;

public class DBQueries {
	
	public static String ADD_USER_QUERY =  new StringBuilder().
		    append("INSERT INTO userdetails              ").
		    append("            (username,               ").
		    append("             password,               ").
		    append("             email_id,               ").
		    append("             phone_no,               ").
		    append("             date_of_birth,          ").
		    append("             gender,                 ").
		    append("             role,                  ").
		    append("             status)                 ").
		    append("VALUES      (?, ?, ?, ?, ?, ?, ?, ?) ").
		  toString();
	
	public static String IS_USER_NAME_EXISTS_QUERY = "SELECT USERNAME FROM userdetails WHERE username = ? AND email_id = ?";
	
	public static String DELETE_USER_QUERY = "DELETE FROM userdetails WHERE id = ?";
	
	public static String LOGIN_QUERY = new StringBuilder().
	        append(" SELECT *	          ").
		    append(" FROM   userdetails   ").
  		    append(" WHERE  username = ?  ").
  		    append(" AND    password = ?  ").
  		  toString();
	
	public static String GET_USER_BY_ID_QUERY = new StringBuilder().
			append(" SELECT *	          ").
		    append(" FROM   userdetails   ").
  		    append(" WHERE  id = ?  ").
		toString();
	
	public static String UPDATE_USER_QUERY = new StringBuilder().
		    append("UPDATE userdetails   			  ").
		    append("SET    username = ?, password = ?, email_id = ?, phone_no = ?, date_of_birth = ?, status = ? ").
		    append("WHERE  id = ?      				  ").
		toString();
	
	public static String LIST_OF_USERS_QUERY = new StringBuilder().
	            append("SELECT id, username, password, email_id, phone_no, date_of_birth, status  ").
	            append("FROM   userdetails ").
	        toString();
}