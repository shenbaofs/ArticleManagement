package com.objectfrontier.training.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Blob;
import com.objectfrontier.training.article.dao.ArticleDao;
import com.objectfrontier.training.article.model.Article;
import com.objectfrontier.training.article.util.DataBaseUtil;

import static com.objectfrontier.training.article.util.DBQueries.GET_AUTHOR_DETAILS_BY_AUTHOR_ID_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.GET_ARTICLE_DETAILS_BY_ARTICLE_ID_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.LIST_OF_ARTICLES_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.UPLOAD_ARTICLE_QUERY;

public class ArticleDaoImpl implements ArticleDao {
	
	@Override
	public ArrayList<Article> getListOfArticles() throws Exception {
		
		ArrayList<Article> articleList = new ArrayList<Article>();
        Connection connection = DataBaseUtil.getDbConnect();
        PreparedStatement ps = connection.prepareStatement(LIST_OF_ARTICLES_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);;
        ResultSet rs = ps.executeQuery(); 
        while (rs.next()) {
        	Article article = new Article();
        	article.setArticleId(rs.getLong("Article_Id"));
        	article.setArticleName(rs.getString("Article_Name"));
        	article.setCategory(rs.getString("Category"));
        	article.setDescription(rs.getString("Description"));
        	article.setContent(rs.getString("Content"));
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
			Blob img = (Blob)rs.getBlob("Author_Image");
			article.setAuthorImage(img.getBytes(1, (int)img.length()));
		}
		return article;
	}
	
	@Override
	public Article getArticleDetailsById(long articleId) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(GET_ARTICLE_DETAILS_BY_ARTICLE_ID_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, articleId);
		ResultSet rs = ps.executeQuery();
		Article article = new Article();
		if(rs.next()) {
			article.setArticleId(rs.getLong("Article_Id"));
			article.setArticleName(rs.getString("Article_Name"));
			article.setAuthorName(rs.getString("Author_Name"));
			article.setCategory(rs.getString("Category"));
			article.setDescription(rs.getString("Description"));
			article.setContent(rs.getString("Content"));
			article.setDateOfPublish(rs.getDate("date_Of_Publish"));
		}
		return article;
	}
	
	@Override
	public long uploadArticle(Article article) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(UPLOAD_ARTICLE_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, article.getArticleName());
		ps.setString(2, article.getCategory());
		ps.setString(3, article.getDescription());
		ps.setString(4, article.getContent());
		ps.setDate  (5, new java.sql.Date(article.getDateOfPublish().getTime()));
		ps.setString(4, article.getStatus());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);
	 }
}
