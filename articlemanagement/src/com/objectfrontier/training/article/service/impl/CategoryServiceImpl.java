package com.objectfrontier.training.article.service.impl;

import java.util.ArrayList;

import com.objectfrontier.training.article.dao.CategoryDao;
import com.objectfrontier.training.article.dao.impl.CategoryDaoImpl;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Category;
import com.objectfrontier.training.article.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	@Override
	public ArrayList<Category> getListOfCategories() {
		
		try {
				CategoryDao categorydao = new CategoryDaoImpl(); 
				ArrayList<Category> categoryList = new ArrayList<Category>();
				categoryList = categorydao.getListOfCategories();
				return categoryList;
		} catch(Exception e) {
				throw new AppException(e);
		}
	}
}
