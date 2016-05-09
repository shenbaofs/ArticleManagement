package com.objectfrontier.training.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.objectfrontier.training.article.model.User;
import com.objectfrontier.training.article.service.UserService;
import com.objectfrontier.training.article.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	UserService userservice = new UserServiceImpl();
	
	@Test
	public void testaddUserWithEmptyUserName() {
		
		try {
			User user = new User("", "password", "emailId",  9994389919L, new Date(),"gender", "role","status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("username is required",e.getMessage());
		}
		
	}
		
	@Test
	public void testaddUserWithEmptyPassword() {
		
		try {
			User user = new User("username", "", "emailId", 9994389919L, new Date(),"gender", "role", "status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("password is required",e.getMessage());
		}
		
	}
	
	@Test
	public void testaddUserWithEmptyEmailId() {
		
		try {
			User user = new User("username", "password", "", 9994389919L, new Date(),"gender", "role", "status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("email id is required",e.getMessage());
		}
		
	}
	
	@Test
	public void testaddUserWithInvalidPhoneNumber() {
		
		try {
			User user = new User("username", "password", "emailId", 999438L, new Date(),"gender", "role", "status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("invalid phone number",e.getMessage());
		}
	}
	
	@Test
	public void testaddUserWithInvalidDateOfBirth() throws Exception {
		
		try {
			User user = new User("username", "password", "emailId", 9994389919L, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("1914-02-19 1:2"), "gender", "role", "status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("user should be within 18 to 100 years", e.getMessage());
		}
			
	}
	
	@Test
	public void testaddUserAlreadyExists() {
		
		try {
			User user = new User("meenakshi6", "password", "meenakshi@ofs.com", 9994389919L, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("1998-02-02 1:2"),"gender", "role", "status");
			userservice.addUser(user);
		} catch(Exception e) {
			assertEquals("user already exists", e.getMessage());
		}
		
	}
		
	@Test
	public void testaddUser() {
		
		User user = new User("deepa12", "Deepa12@", "deepa@ofs.com", 9955226659L, new Date(1994-12-22),"female", "user", "WFA");	
		User result = userservice.addUser(user);
		assertEquals(user.getUsername(), result.getUsername());
		assertEquals(user.getPassword(), result.getPassword());
		assertEquals(user.getEmailId(), result.getEmailId());
		assertEquals(user.getPhoneNo(), result.getPhoneNo());
		assertEquals(user.getDateOfBirth(), result.getDateOfBirth());
		assertEquals(user.getGender(), result.getGender());
		assertNotEquals(0, user.getId());
		userservice.deleteUser(user.getId());
	  }
	
	@Test
	public void testuserLogin() {
			
		String username = "shenba94";
		String password = "Shenba@06";
		User user = new User();	
		User result = userservice.userLogin(username, password);
		user.setRole("admin");
		assertEquals(user.getRole(), result.getRole());
	}
	
	@Test
	public void testgetUserById() {
		
		User user = new User(2);
		user.setUsername("meenakshi6");
		user.setEmailId("meenakshi@ofs.com");
		User result = userservice.getUserById(user.getId());
		assertEquals(user.getUsername(), result.getUsername());
		assertEquals(user.getEmailId(), result.getEmailId());
	}
	
	@Test
	public void testUpdateUserDetails() { 
		
		User user = new User(128, "Karthi@12", 9955226659L);
		boolean flag = userservice.updateUserDetails(user);
		assertTrue(flag);
	}
	
	@Test
	public void testgetListOfUsers() {
	
		ArrayList<User> list = userservice.getListOfUsers("APPROVED");
		User user = new User("deepa1", "Deepa12@", "deepa@ofs.com", 9955226659L, new Date(1994-12-22),"female", "user", "WFA");	
		userservice.addUser(user);
//		assertThat(userservice.getListOfUsers(), contains(result);
		assertEquals(list.size(), 10);
	}	
}

