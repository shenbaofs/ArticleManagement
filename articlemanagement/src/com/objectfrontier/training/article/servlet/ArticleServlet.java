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
	 ArticleService articleservice = new ArticleServiceImpl();
	    
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) { 
			
		String idString = req.getParameter("authorId");
		
		try {
			if(!(idString == null)) {
				res.setContentType("application/json");
				long authorId  = Long.parseLong(idString);		
			    Article article = articleservice.getAuthorDetailsById(authorId);
			    String articleString = JsonUtil.toJSON(article);
			    PrintWriter pw = res.getWriter(); 
			    res.getWriter().write(articleString);
			    pw.close();
			} else {
				res.setContentType("application/json");
				String category  = req.getParameter("category");
				ArrayList<Article> articles = articleservice.getListOfArticles(category);
				String articleString = JsonUtil.toJSON(articles);
				PrintWriter pw = res.getWriter(); 
				res.getWriter().write(articleString);
				pw.close();
			}
		}  catch (Exception e) {	
				res.setStatus(500);
				throw new AppException(e);
		}
	}
}
