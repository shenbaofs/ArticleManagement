package com.objectfrontier.training.article.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Category;
import com.objectfrontier.training.article.model.JsonUtil;
import com.objectfrontier.training.article.service.CategoryService;
import com.objectfrontier.training.article.service.impl.CategoryServiceImpl;

public class CategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	CategoryService categoryservice = new CategoryServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) { 
		
		try {
				res.setContentType("application/json");
				ArrayList<Category> category = categoryservice.getListOfCategories();
				String userString = JsonUtil.toJSON(category);
				PrintWriter pw = res.getWriter(); 
				res.getWriter().write(userString);
				pw.close();
		}  catch (Exception e) {	
			res.setStatus(500);
			throw new AppException(e);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
		    res.setContentType("application/json");
	        StringBuffer requestJSON = new StringBuffer();
			String line = null;
	        try {
	        	BufferedReader reader = req.getReader();
			    while ((line = reader.readLine()) != null)
			    	requestJSON.append(line);
				Category category = JsonUtil.fromJSON(requestJSON.toString(), Category.class);	
				categoryservice.addCategory(category);
			} catch (Exception e) {
				throw new AppException(e);
			}
    }
	

}
