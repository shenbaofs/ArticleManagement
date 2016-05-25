package com.objectfrontier.training.article.servlet;

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
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) { 
		
		try {
				res.setContentType("application/json");
				CategoryService categoryservice = new CategoryServiceImpl();
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

}
