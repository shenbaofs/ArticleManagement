package com.objectfrontier.training.article.service.impl;

import java.util.ArrayList;

import com.objectfrontier.training.article.dao.UserDao;
import com.objectfrontier.training.article.dao.impl.UserDaoImpl;
import com.objectfrontier.training.article.model.AppErrorCode;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.User;
import com.objectfrontier.training.article.service.UserService;
import com.objectfrontier.training.article.util.ArticleManagementValidation;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	ArticleManagementValidation validation = new ArticleManagementValidation();

	private void isUserExists (User user) {
		try {
			boolean flag = userDao.isUserExists(user);
			if (flag == true) {
				throw new AppException(AppErrorCode.USER_NAME_ALREADY_EXISTS);
			}
		} catch(Exception e) {
			throw new AppException(e);
		}
	}

	@Override	 
	public User addUser(User user) {
		
		validation.validateUserDetails(user);
		isUserExists(user);
		try {
			long id = userDao.addUser(user);
			user.setId(id);
		} catch(Exception e) {
			throw new AppException(e);
		}
		return user;
	}
	
	@Override
	public void deleteUser(long id) {
		
		try {
			int rowsAffected = userDao.deleteUser(id);
			if(!(rowsAffected == 1)) {
				throw new AppException(AppErrorCode.USER_NOT_FOUND);
			}
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
	
	@Override
	public User userLogin(String username, String password) {
		
		validation.validateUserDetailsForLogin(username, password);
		try {
			User user =	userDao.userLogin(username, password);
			if (user.getRole() == "admin") {
				throw new AppException(AppErrorCode.UNAUTHORIZED_OPERATION);
			} else {
				if(user.getUsername() == null) {
					throw new AppException(AppErrorCode.INVALID_LOGIN_CREDENTIALS);
				} 
			return user;
			}
	    } catch (Exception e) {
			throw new AppException(e);
		}
		
	}	
	
	@Override
	public User getUserById(long id) {
		
		try {
			User user = userDao.getUserById(id);
			if(user == null) {
				throw new AppException(AppErrorCode.USER_NOT_FOUND);
			} else {
				return user;
			}
	    } catch (Exception e) {
			throw new AppException(e);
	    }
	}
	
	@Override
	public boolean updateUserDetails(User user) {
		
		try {
			int rowsAffected = userDao.updateUserDetails(user);
			if(!(rowsAffected == 1)) {
				throw new AppException(AppErrorCode.USER_DETAILS_NOT_UPDATED);
			} 
		} catch(Exception e) {
			throw new AppException(e);
		}
		return true;
	}
	
	@Override
	public ArrayList<User> getListOfUsers(String status) {
		
		try {
			ArrayList<User> userList = new ArrayList<User>();
			if(status == "ALL") {
				userList = userDao.getListOfAllUsers(status);
			} else if (status == "APPROVED") {
				userList = userDao.getListOfApprovedUsers(status);
			} else if (status == "DISAPPROVED") {
				userList = userDao.getListOfDisapprovedUsers(status);
			} else if (status == "WFA") {
				userList = userDao.getListOfWFAUsers(status);
			} 
			return userList;
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
}
