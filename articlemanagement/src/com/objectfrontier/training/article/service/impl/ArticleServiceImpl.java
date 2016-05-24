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
	public boolean updateArticleStatus(String status, long articleId) {
		
		try {
			int rowsAffected = articleDao.updateArticleStatus(status, articleId);
			if(rowsAffected != 1) {
				throw new AppException(AppErrorCode.ARTICLE_STATUS_NOT_UPDATED);
			} 
		} catch(Exception e) {
			throw new AppException(e);
		}
		return true;
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
	
	@Override
	public Article getArticleDetailsById(long articleId) {
		
		Article article = new Article();
		try {
			article = articleDao.getArticleDetailsById(articleId);
			if(article == null) {
				throw new AppException(AppErrorCode.ARTICLE_NOT_FOUND);
			} 
	    } catch (Exception e) {
			throw new AppException(e);
	    }
		return article;
	}
	
	@Override	 
	public Article uploadArticle(Article article) {
		
		try {
			ArticleDao articleDao = new ArticleDaoImpl();
			long articleId = articleDao.uploadArticle(article);
			article.setArticleId(articleId);
		} catch(Exception e) {
			throw new AppException(e);
		}
		return article;
	}
}
