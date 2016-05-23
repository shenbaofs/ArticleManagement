package com.objectfrontier.training.article.service.impl;

import com.objectfrontier.training.article.dao.AuthorDao;
import com.objectfrontier.training.article.dao.impl.AuthorDaoImpl;
import com.objectfrontier.training.article.model.AppException;
import com.objectfrontier.training.article.model.Author;
import com.objectfrontier.training.article.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
	
	@Override	 
	public Author uploadAuthorDetails(Author author) {
		
		try {
			AuthorDao authorDao = new AuthorDaoImpl();
			long authorId = authorDao.uploadAuthorDetails(author);
			author.setAuthorId(authorId);
		} catch(Exception e) {
			throw new AppException(e);
		}
		return author;
	}
}
