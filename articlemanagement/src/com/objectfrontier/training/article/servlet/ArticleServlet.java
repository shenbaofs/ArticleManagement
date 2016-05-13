package com.objectfrontier.training.article.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.model.JsonUtil;
import com.objectfrontier.training.article.service.ArticleService;
import com.objectfrontier.training.article.service.impl.ArticleServiceImpl;

public class ArticleServlet extends HttpServlet {
	
	 private static final long serialVersionUID = 1L; 
	    
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) { 
			
		try {
			res.setContentType("application/json");
			String category  = req.getParameter("category");
			ArticleService articleservice = new ArticleServiceImpl();
			ArrayList<Article> articles = articleservice.getListOfArticles(category);
			String articleString = JsonUtil.toJSON(articles);
			PrintWriter pw = res.getWriter(); 
			res.getWriter().write(articleString);
			pw.close();
		}  catch (Exception e) {	
			res.setStatus(500);
			throw new AppException(e);
		}
	}

}
