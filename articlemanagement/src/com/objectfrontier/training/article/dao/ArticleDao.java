package com.objectfrontier.training.article.dao;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.model.Author;

public interface ArticleDao {

	/* To  get list of articles available in database */
	 ArrayList<Article> getListOfArticles() throws Exception;
	 
	 /* To  get author details using authorId */
	 Author getAuthorDetailsById(long authorId) throws Exception;
	 
	 /* To  get article details using articleId */
	 Article getArticleDetailsById(long articleId) throws Exception;
	 
	/* To update article status */
	int updateArticleStatus(String status, long articleId) throws Exception;
	 
	 /* To upload author details */
	long uploadArticle(Article article) throws Exception;
}
