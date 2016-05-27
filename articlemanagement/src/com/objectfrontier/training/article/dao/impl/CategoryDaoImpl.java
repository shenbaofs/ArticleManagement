package com.objectfrontier.training.article.dao.impl;

import static com.objectfrontier.training.article.util.DBQueries.ADD_CATEGORY_QUERY;
import static com.objectfrontier.training.article.util.DBQueries.LIST_OF_CATAGORIES_QUERY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.objectfrontier.training.article.dao.CategoryDao;
import com.objectfrontier.training.article.model.Category;
import com.objectfrontier.training.article.util.DataBaseUtil;

public class CategoryDaoImpl implements CategoryDao {
	
	@Override
	public ArrayList<Category> getListOfCategories() throws Exception {
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
        Connection connection = DataBaseUtil.getDbConnect();
        PreparedStatement ps = connection.prepareStatement(LIST_OF_CATAGORIES_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);;
        ResultSet rs = ps.executeQuery(); 
        while (rs.next()) {
        	Category category = new Category();
        	category.setCategoryId(rs.getLong("Category_Id"));
        	category.setCategoryName(rs.getString("Category_Name"));
        	categoryList.add(category); 
        	}	
        return categoryList;
    }
	
	@Override
	public long addCategory(Category category) throws Exception {
		
		Connection connection = DataBaseUtil.getDbConnect();
		PreparedStatement ps = connection.prepareStatement(ADD_CATEGORY_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, category.getCategoryName());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);
	 }

}
