package com.objectfrontier.training.article.dao;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Article;

public interface ArticleDao {

	/* To  get list of articles available in database */
	 ArrayList<Article> getListOfArticles() throws Exception;
	 
	 /* To  get author details using authorId */
	 Article getAuthorDetailsById(long authorId) throws Exception;

}
