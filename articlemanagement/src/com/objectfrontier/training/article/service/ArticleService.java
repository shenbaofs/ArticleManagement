package com.objectfrontier.training.article.service;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.model.Author;

public interface ArticleService {

    /* To get list of articles available in database based on category */
    ArrayList<Article> getListOfArticles(String category);
    
    /* To get author details using authorId */
    Author getAuthorDetailsById(long authorId);
    
    /* To get article details using articleId */
    Article getArticleDetailsById(long articleId);
    
	/* To update article status */
    boolean updateArticleStatus(String status, long articleId);
    
    /* To upload article */
	Article uploadArticle(Article article);

}