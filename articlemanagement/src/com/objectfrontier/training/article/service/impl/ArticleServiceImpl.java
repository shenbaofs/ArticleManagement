package com.objectfrontier.training.article.service.impl;

import java.util.ArrayList;

import com.objectfrontier.training.article.dao.ArticleDao;
import com.objectfrontier.training.article.dao.impl.ArticleDaoImpl;
import com.objectfrontier.training.article.model.AppErrorCode;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	ArticleDao articleDao = new ArticleDaoImpl();
	
	@Override
	public ArrayList<Article> getListOfArticles(String category) {
		
		try {
			ArrayList<Article> articleList = new ArrayList<Article>();
			articleList= articleDao.getListOfArticles();
			if(!(category.equalsIgnoreCase("ALL"))) {
				ArrayList<Article> selectedArticleList = new ArrayList<Article>();
				for(Article article : articleList) {
					if(article.getCategory().equalsIgnoreCase(category)) {
						selectedArticleList.add(article);
					}
				}
				return selectedArticleList;
			}
			return articleList;
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
	
	@Override
	public Article getAuthorDetailsById(long authorId) {
		
		Article article = new Article();
		try {
			article = articleDao.getAuthorDetailsById(authorId);
			if(article == null) {
				throw new AppException(AppErrorCode.AUTHOR_NOT_FOUND);
			} 
	    } catch (Exception e) {
			throw new AppException(e);
	    }
		return article;
	}
}
