package com.objectfrontier.training.article.service;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.User;

public interface UserService {
	
	/* To create new user */
	User addUser(User user);
	 
	/* To delete user */
	void deleteUser(long id);
	
	/* To login existing user */
	User userLogin(String username, String password);

	/* To get user details using id */
	User getUserById(long id);
	
	/* To update user details */
	boolean updateUserDetails(User user);
	
	/* To get list of users available in database */
	ArrayList<User> getListOfUsers(String status);
}
