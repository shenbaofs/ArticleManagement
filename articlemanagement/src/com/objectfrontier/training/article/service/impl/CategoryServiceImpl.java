package com.objectfrontier.training.article.service.impl;

import java.util.ArrayList;

import com.objectfrontier.training.article.dao.CategoryDao;
import com.objectfrontier.training.article.dao.impl.CategoryDaoImpl;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Category;
import com.objectfrontier.training.article.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao categorydao = new CategoryDaoImpl(); 
	
	@Override
	public ArrayList<Category> getListOfCategories() {
		
		try {
			ArrayList<Category> categoryList = new ArrayList<Category>();
			categoryList = categorydao.getListOfCategories();
			return categoryList;
		} catch(Exception e) {
				throw new AppException(e);
		}
	}
	
	@Override	 
	public Category addCategory(Category category) {
		
		try {
			long categoryId = categorydao.addCategory(category);
			category.setCategoryId(categoryId);
			return category;
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
}	
