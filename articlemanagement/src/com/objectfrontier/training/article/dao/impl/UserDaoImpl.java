package com.objectfrontier.training.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.objectfrontier.training.article.dao.UserDao;
import com.objectfrontier.training.article.model.User;
import com.objectfrontier.training.article.util.DataBaseUtil;

import static com.objectfrontier.training.article.util.DBQueries.ADD_USER_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.IS_USER_NAME_EXISTS_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.DELETE_USER_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.LOGIN_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.GET_USER_BY_ID_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.UPDATE_USER_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.LIST_OF_USERS_QUERY; 

public class UserDaoImpl implements UserDao {

	public static final String ROLE = "user";
	public static final String STATUS = "WFA";
	
	@Override
	public long addUser(User user) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(ADD_USER_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmailId()); 
		ps.setLong  (4, user.getPhoneNo()); 
		ps.setDate  (5, new java.sql.Date(user.getDateOfBirth().getTime()));
		ps.setString(6, user.getGender());
		ps.setString(7, ROLE);
		ps.setString(8, STATUS);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);
	 }

	@Override
	public boolean isUserExists(User user) throws Exception {
		
		PreparedStatement ps = (DataBaseUtil.getDbConnect()).prepareStatement(IS_USER_NAME_EXISTS_QUERY);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getEmailId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int deleteUser(long id) throws Exception {
		
		PreparedStatement ps = (DataBaseUtil.getDbConnect()).prepareStatement(DELETE_USER_QUERY);
		ps.setLong(1, id);
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}
	
	@Override
	public User userLogin(String username, String password) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(LOGIN_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setUsername(rs.getString("username"));
			user.setId(rs.getLong("id"));
			user.setRole(rs.getString("role"));
			user.setStatus(rs.getString("status"));
		}
		return user;
    }
	
	@Override
	public User getUserById(long id) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmailId(rs.getString("email_id"));
			user.setPhoneNo(rs.getLong("phone_no"));
			user.setDateOfBirth(rs.getDate("date_of_birth"));
			user.setGender(rs.getString("gender"));
			user.setRole(rs.getString("role"));
			user.setStatus(rs.getString("status"));
		}
		return user;
	}
	
	@Override
	public int updateUserDetails(User user) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(UPDATE_USER_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmailId());
		ps.setLong(4, user.getPhoneNo());
		ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
		ps.setString(6, user.getStatus());
		ps.setLong(7, user.getId());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}
	
	@Override
	public ArrayList<User> getListOfAllUsers() throws Exception {
		
		ArrayList<User> userList = new ArrayList<>();
        Connection connection = DataBaseUtil.getDbConnect();
        PreparedStatement ps = connection.prepareStatement(LIST_OF_USERS_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);;
        ResultSet rs = ps.executeQuery(); 
        while (rs.next()) {
        	User user = new User();
        	user.setId(rs.getLong("id"));
        	user.setUsername(rs.getString("username"));
        	user.setPassword(rs.getString("password"));
        	user.setEmailId(rs.getString("email_id"));
        	user.setPhoneNo(rs.getLong("phone_no"));
        	user.setDateOfBirth(rs.getDate("date_of_birth"));
        	user.setStatus(rs.getString("status"));
        	userList.add(user); 
        	}	
        return userList;
    } 
}
