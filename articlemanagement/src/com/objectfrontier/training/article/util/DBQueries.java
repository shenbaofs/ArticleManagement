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
		    append("SET    username = ?, password = ?, email_id = ?, phone_no = ?, date_of_birth = ?, status = ?").
		    append("WHERE  id = ?      				  ").
		toString();
	
	public static String LIST_OF_USERS_QUERY = new StringBuilder().
	            append("SELECT  * ").
	            append("FROM   userdetails ").
	        toString();
	
	public static String LIST_OF_ARTICLES_QUERY = new StringBuilder().
				append("SELECT articles.Article_Id, articles.Article_Name,").
				append("articles.Description, articles.Content, articles.date_Of_Publish, articles.status,").
                append("authordetails.Author_Id, authordetails.Author_Name,").
                append("category.Category_Name").
                append(" FROM articles INNER JOIN authordetails ON articles.Author_Id=authordetails.Author_Id INNER JOIN category ON articles.Category_Id=category.Category_Id ").
			toString();
	
	public static String GET_AUTHOR_DETAILS_BY_AUTHOR_ID_QUERY = new StringBuilder().
			append(" SELECT *	          ").
		    append(" FROM   authordetails ").
  		    append(" WHERE  Author_Id = ? ").
		toString();
	
	public static String GET_ARTICLE_DETAILS_BY_ARTICLE_ID_QUERY = new StringBuilder().
			append(" SELECT articles.*, authordetails.Author_Name, category.Category_Name  ").
		    append(" FROM   articles LEFT JOIN authordetails ON articles.Author_Id = authordetails.Author_Id LEFT JOIN category ON articles.Category_Id = category.Category_Id").
  		    append(" WHERE  Article_Id = ?").
		toString();
	
	public static String UPDATE_ARTICLE_STATUS_QUERY = new StringBuilder().
		    append("UPDATE articles         ").
		    append("SET    status = ?          ").
		    append("WHERE  Article_Id = ?      ").
		toString();
	
	public static String UPLOAD_AUTHOR_DETAILS_QUERY = new StringBuilder().
		    append("INSERT INTO authordetails            ").
		    append("            (Author_Name,            ").
		    append("             Author-Carrer_Profile,  ").
		    append("             Author_Image)           ").
		    append("VALUES      (?, ?, ?) ").
		  toString();
	
	public static String ADD_CATEGORY_QUERY = new StringBuilder().
		    append(" INSERT INTO category (`Category_Name`) VALUES (?)").
		  toString();
	
	public static String  UPLOAD_ARTICLE_QUERY = new StringBuilder().
		    append("INSERT INTO articles              ").
		    append("            (Article_Name,        ").
		    append("             Category,            ").
		    append("             Description,         ").
		    append("             Content,             ").
		    append("             date_Of_Publish,     ").
		    append("             status)              ").
		    append("VALUES      (?, ?, ?, ?, ?, ?)    ").
		  toString();
	
	public static String LIST_OF_CATAGORIES_QUERY = new StringBuilder().
			append(" SELECT *	        ").
		    append(" FROM   category    ").
		  toString();
}