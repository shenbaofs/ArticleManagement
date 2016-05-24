package com.objectfrontier.training.article.service;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Article;

public interface ArticleService {

    /* To get list of articles available in database */
    ArrayList<Article> getListOfArticles(String category);
    
    /* To get author details using authorId */
    Article getAuthorDetailsById(long authorId);
    
    /* To get article details using articleId */
    Article getArticleDetailsById(long articleId);
    
	/* To update article status */
    boolean updateArticleStatus(String status, long articleId);
    
    /* To upload article */
	Article uploadArticle(Article article);

}