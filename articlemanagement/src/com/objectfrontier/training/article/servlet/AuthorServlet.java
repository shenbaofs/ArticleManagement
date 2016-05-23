package com.objectfrontier.training.article.servlet;

import java.io.BufferedReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Author;
import com.objectfrontier.training.article.model.JsonUtil;
import com.objectfrontier.training.article.service.AuthorService;
import com.objectfrontier.training.article.service.impl.AuthorServiceImpl;

public class AuthorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	AuthorService authorservice = new AuthorServiceImpl();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        res.setContentType("application/json");
        StringBuffer requestJSON = new StringBuffer();
		String line = null;
        try {
        	BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		    	requestJSON.append(line);
			Author author = JsonUtil.fromJSON(requestJSON.toString(), Author.class);
	        authorservice.uploadAuthorDetails(author);
		} catch (Exception e) {
			throw new AppException(e);
		}
    }
}
