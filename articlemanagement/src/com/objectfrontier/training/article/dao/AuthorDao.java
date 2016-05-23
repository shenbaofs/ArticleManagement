package com.objectfrontier.training.article.dao;

import com.objectfrontier.training.article.model.Author;

public interface AuthorDao {
	
	/* To upload author details */
	long uploadAuthorDetails(Author author) throws Exception;

}
