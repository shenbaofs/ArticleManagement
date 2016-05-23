package com.objectfrontier.training.article.dao.impl;

import static com.objectfrontier.training.article.util.DBQueries.UPLOAD_AUTHOR_DETAILS_QUERY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.objectfrontier.training.article.dao.AuthorDao;
import com.objectfrontier.training.article.model.Author;
import com.objectfrontier.training.article.util.DataBaseUtil;

public class AuthorDaoImpl implements AuthorDao {
	
	@Override
	public long uploadAuthorDetails(Author author) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(UPLOAD_AUTHOR_DETAILS_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, author.getAuthorName());
		ps.setString(2, author.getAuthorCarrerProfile());
		ps.setBytes(3, author.getAuthorImage());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);
	 }
}
