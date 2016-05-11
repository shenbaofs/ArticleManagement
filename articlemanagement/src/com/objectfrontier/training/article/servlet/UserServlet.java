package com.objectfrontier.training.article.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.JsonUtil;
import com.objectfrontier.training.article.model.User;
import com.objectfrontier.training.article.service.UserService;
import com.objectfrontier.training.article.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; 
	UserService userservice = new UserServiceImpl();
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        res.setContentType("application/json");
        StringBuffer requestJSON = new StringBuffer();
		String line = null;
        try {
        	BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		    	requestJSON.append(line);
			User user = JsonUtil.fromJSON(requestJSON.toString(), User.class);
	        userservice.addUser(user);
		} catch (Exception e) {
			throw new AppException(e);
		}
    }
	
	@Override
	 public void doPut(HttpServletRequest req, HttpServletResponse res) {
			
			try {
				res.setContentType("application/json");
				StringBuffer requestJSON = new StringBuffer();
				String line = null;
				BufferedReader reader = req.getReader();
				while ((line = reader.readLine()) != null)
			    requestJSON.append(line);
				User user = JsonUtil.fromJSON(requestJSON.toString(), User.class);
				userservice.updateUserDetails(user);
	        } catch (Exception e) {
	        	throw new AppException(e);
	        }
	}
	
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) { 
		
		String idString = req.getParameter("id");
		
		try {
			if(!(idString == null)) {
				res.setContentType("application/json");
				long id  = Long.parseLong(idString);		
			    User user = userservice.getUserById(id);
			    String userString = JsonUtil.toJSON(user);
			    PrintWriter pw = res.getWriter(); 
			    res.getWriter().write(userString);
			    pw.close();
			} else {
				res.setContentType("application/json");
				String status  = req.getParameter("status");
				ArrayList<User> user = userservice.getListOfUsers(status);
				String userString = JsonUtil.toJSON(user);
				PrintWriter pw = res.getWriter(); 
				res.getWriter().write(userString);
				pw.close();
			}
		}  catch (Exception e) {	
			res.setStatus(500);
			throw new AppException(e);
		}
	}
}  
