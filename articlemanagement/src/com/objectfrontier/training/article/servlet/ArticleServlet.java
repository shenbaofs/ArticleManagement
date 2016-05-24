package com.objectfrontier.training.article.servlet;

import java.io.BufferedReader;
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
			
		String authorIdString = req.getParameter("authorId");
		String category  = req.getParameter("category");
		String articleIdString = req.getParameter("articleId");
		
		try {
			if(!(authorIdString == null)) {
				res.setContentType("application/json");
				long authorId  = Long.parseLong(authorIdString);		
			    Article article = articleservice.getAuthorDetailsById(authorId);
			    String articleString = JsonUtil.toJSON(article);
			    PrintWriter pw = res.getWriter(); 
			    res.getWriter().write(articleString);
			    pw.close();
			} else if(!(category == null)) {
				res.setContentType("application/json");
				ArrayList<Article> articles = articleservice.getListOfArticles(category);
				String articleString = JsonUtil.toJSON(articles);
				PrintWriter pw = res.getWriter(); 
				res.getWriter().write(articleString);
				pw.close();
			} else if(!(articleIdString == null)) {
				long articleId  = Long.parseLong(articleIdString);	
				res.setContentType("application/json");
				Article article = articleservice.getArticleDetailsById(articleId);
				String articleIdStringJson = JsonUtil.toJSON(article);
				PrintWriter pw = res.getWriter(); 
				res.getWriter().write(articleIdStringJson);
				pw.close();
			} 
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
				Article article = JsonUtil.fromJSON(requestJSON.toString(), Article.class);	
		        articleservice.uploadArticle(article);
			} catch (Exception e) {
				throw new AppException(e);
			}
    }
	
	@Override
	 public void doPut(HttpServletRequest req, HttpServletResponse res) {
			
			try {
				res.setContentType("application/json");
				String status = req.getParameter("status");
				String idString1 = req.getParameter("articleId");
				long articleId  = Long.parseLong(idString1);
				boolean article = articleservice.updateArticleStatus(status, articleId);
				String userString = JsonUtil.toJSON(article);
	            PrintWriter pw = res.getWriter(); 
	            res.getWriter().write(userString);
	            pw.close();
	            res.setStatus(200);   
	        } catch (Exception e) {
	        	throw new AppException(e);
	        }
	}
}
