package com.objectfrontier.training.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.objectfrontier.training.article.dao.ArticleDao;
import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.util.DataBaseUtil;

import static com.objectfrontier.training.article.util.DBQueries.GET_AUTHOR_DETAILS_BY_AUTHOR_ID_QUERY;
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
        	article.setCategory(rs.getString("Category"));
        	article.setDescription(rs.getString("Description"));
        	article.setDateOfPublish(rs.getDate("date_Of_Publish"));
        	article.setStatus(rs.getString("status"));
        	article.setAuthorId(rs.getLong("Author_Id"));
        	article.setAuthorName(rs.getString("Author_Name"));
           	articleList.add(article); 
        	}	
        return articleList;
    } 
	
	@Override
	public Article getAuthorDetailsById(long authorId) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(GET_AUTHOR_DETAILS_BY_AUTHOR_ID_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, authorId);
		ResultSet rs = ps.executeQuery();
		Article article = new Article();
		if(rs.next()) {
			article.setAuthorId(rs.getLong("Author_Id"));
			article.setAuthorName(rs.getString("Author_Name"));
			article.setAuthorCarrerProfile(rs.getString("Author_Carrer_Profile"));
			article.setAuthorImage(rs.getBytes("Author_Image"));
		}
		return article;
	}
}
