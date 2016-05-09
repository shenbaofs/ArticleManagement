package com.objectfrontier.training.article.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.JsonUtil;
import com.objectfrontier.training.article.model.User;
import com.objectfrontier.training.article.service.UserService;
import com.objectfrontier.training.article.service.impl.UserServiceImpl;

public class LoginServlet 
extends HttpServlet	{
	
	private static final long serialVersionUID = 1L; 
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.setContentType("application/json");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
		    UserService userservice = new UserServiceImpl();
		    User user = userservice.userLogin(username, password);
		    String userString = JsonUtil.toJSON(user);
		    PrintWriter pw = res.getWriter(); 
		    res.getWriter().write(userString);
		    pw.close();
		    res.setStatus(200);	  
		} catch (Exception e) {	
				res.setStatus(500);
				throw new AppException(e);
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) { 
		
		try {
			res.setContentType("application/json");
			String idString = req.getParameter("id");
			long id  = Long.parseLong(idString);
			/*
			 * 
			 * if(id==0){
			 * list = dao.getAll()
			 * } else if(id == 1){
			 * list = dao.getWTA()	
			 * }
			 * return list;
			 * 
			 * */
			UserService userservice = new UserServiceImpl();			
		    User user = userservice.getUserById(id);
		    String userString = JsonUtil.toJSON(user);
		    PrintWriter pw = res.getWriter(); 
		    res.getWriter().write(userString);
		    pw.close();
		}  catch (Exception e) {	
			res.setStatus(500);
			throw new AppException(e);
		}
	}
}
