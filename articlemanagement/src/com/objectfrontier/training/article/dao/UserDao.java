package com.objectfrontier.training.article.dao;
 
import java.util.ArrayList;

import com.objectfrontier.training.article.model.User;

public interface UserDao {
	
	/* To add new user */
	long addUser(User user) throws Exception;
	
	/* To check user already exists */
	boolean isUserExists(User user) throws Exception;	
	
	/* To delete user */
	int deleteUser(long id) throws Exception;
	
	/* To login existing user */
	User userLogin(String username, String password) throws Exception;
	
	/* To get user details using id */
	User getUserById(long id) throws Exception;
	
	/* To update user details */
	int updateUserDetails(User user) throws Exception;
	
	/* To get list of  all users available in database */
	ArrayList<User> getListOfAllUsers(String status) throws Exception; 
	
	/* To get list of approved users available in database */
	ArrayList<User> getListOfApprovedUsers(String status) throws Exception;
	
	/* To get list of disapproved users available in database */
	ArrayList<User> getListOfDisapprovedUsers(String status) throws Exception;
	
	/* To get list of WFA users available in database */
	ArrayList<User> getListOfWFAUsers(String status) throws Exception ;
	
	/* To update user status as approved*/
	int updateUserStatus(long id, String status) throws Exception;
	
}
