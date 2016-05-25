package com.objectfrontier.training.article.dao;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Category;

public interface CategoryDao {
	
	/* To  get list of categories available in database */
	 ArrayList<Category> getListOfCategories() throws Exception;
	 

}
