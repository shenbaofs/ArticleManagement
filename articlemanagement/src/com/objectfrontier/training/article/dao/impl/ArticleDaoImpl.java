package com.objectfrontier.training.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.objectfrontier.training.article.dao.ArticleDao;
import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.util.DataBaseUtil;
import static com.objectfrontier.training.article.util.DBQueries.LIST_OF_ARTICLES_QUERY;

public class ArticleDaoImpl implements ArticleDao {
	
	@Override
	public ArrayList<Article> getListOfArticles() throws Exception {
		
		ArrayList<Article> articleList = new ArrayList<Article>();
        Connection connection = DataBaseUtil.getDbConnect();
        PreparedStatement ps = connection.prepareStatement(LIST_OF_ARTICLES_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);;
        ResultSet rs = ps.executeQuery(); 
        while (rs.next()) {
        	Article article = new Article();
        	article.setId(rs.getLong("id"));
        	article.setArticleName(rs.getString("Article_Name"));
        	article.setAuthor(rs.getString("Author"));
        	article.setCategory(rs.getString("Category"));
        	article.setDescription(rs.getString("Description"));
        	article.setDateOfPublish(rs.getDate("date_Of_Publish"));
        	article.setStatus(rs.getString("status"));
        	articleList.add(article); 
        	}	
        return articleList;
    } 

}
