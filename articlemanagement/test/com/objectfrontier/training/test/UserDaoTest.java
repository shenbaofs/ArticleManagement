package com.objectfrontier.training.test;

import junit.framework.TestCase;

import java.util.Date;

import com.objectfrontier.training.article.dao.UserDao;
import com.objectfrontier.training.article.dao.impl.UserDaoImpl;
import com.objectfrontier.training.article.model.User;

public class UserDaoTest extends TestCase {
	
	public void testAddUserQuery() throws Exception {
		
		User user = new User();
		user.setUsername("sam");
	    user.setPassword("sam06");
	    user.setEmailId("sam@ofs.com");
	    user.setPhoneNo(9944981099L);
	    user.setDateOfBirth(new Date(1994-05-17));
	    user.setGender("male");
	    UserDao userDao = new UserDaoImpl();
	    long id= userDao.addUser(user);
	    assertNotNull(id);
    } 
	
	public void testIsUserExistsQuery() throws Exception {
		
		User user = new User();
		user.setUsername("sam");
		user.setEmailId("sam@ofs.com");
	    UserDao userDao = new UserDaoImpl();
	    boolean flag = userDao.isUserExists(user);
	    assertTrue(flag);
	}

	public void testIsUserDoesNotExistsQuery() throws Exception {
		
		User user = new User();
		user.setUsername("Rathna");
		user.setEmailId("Rathna@ofs.com");
	    UserDao userDao = new UserDaoImpl();
	    boolean flag = userDao.isUserExists(user);
	    assertFalse(flag);
	}

	
	public void testLoginQuery() throws Exception {
		
		User user = new User();
	    String username = "shenba94";
		String password = "Shenba@06";
		UserDao userDao = new UserDaoImpl();
		User result = userDao.userLogin(username, password);
	    user.setUsername(result.getUsername());
	    assertEquals(user.getUsername(), result.getUsername());
	}
	
	public void testgetUserByIdQuery() throws Exception {
		
		User user = new User();
		long id = 2;
		UserDao userDao = new UserDaoImpl();
		User result = userDao.getUserById(id);
		user.setUsername(result.getUsername());
		user.setEmailId(result.getEmailId());
	    assertEquals(user.getUsername(), result.getUsername());
	    assertEquals(user.getEmailId(), result.getEmailId());
	}
	
	public void testupdateUserDetailsQuery() throws Exception {
		
		User user = new User();
		user.setPassword("Karthik@3");
		user.setPhoneNo(951230476L);
	    UserDao userDao = new UserDaoImpl();
	    int rowsAffected = userDao.updateUserDetails(user);
	    assertNotNull(rowsAffected);
	}

}

