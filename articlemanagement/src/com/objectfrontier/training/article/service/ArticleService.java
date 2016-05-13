package com.objectfrontier.training.article.service;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Article;

public interface ArticleService {

    /* To get list of articles available in database */
    ArrayList<Article> getListOfArticles(String category);

}