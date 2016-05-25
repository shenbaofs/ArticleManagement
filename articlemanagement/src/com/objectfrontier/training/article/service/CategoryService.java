package com.objectfrontier.training.article.service;

import java.util.ArrayList;

import com.objectfrontier.training.article.model.Category;

public interface CategoryService {
	
	/* To get list of categories available in database */
	ArrayList<Category> getListOfCategories();
}
