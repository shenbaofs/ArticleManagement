package com.objectfrontier.training.article.util;

import java.sql.Connection;
import java.sql.DriverManager;

 
public class DataBaseUtil {
	public Connection connection;
    public static DataBaseUtil dbConnect;

    private DataBaseUtil() throws Exception {
    	
    	String connectionUrl = "jdbc:mysql://localhost:3306/articlemanagement?user=root&password=MYsql123$";            
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        this.connection = DriverManager.getConnection(connectionUrl);
    }

    public static synchronized Connection getDbConnect() throws Exception {

    	if (dbConnect == null) {
            dbConnect = new DataBaseUtil();
        }
        return dbConnect.connection;
    }
}
