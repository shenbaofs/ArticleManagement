package com.objectfrontier.training.article.model;

import java.util.Date;

public class Article {
	
	private long id;
	private String  articleName;
	private String  author;
	private String  category;
	private String  description;
	private Date    dateOfPublish;
	private String  status;
	
	public Article() {}
	
	public Article(String articleName, String author, String category, String description, Date dateOfPublish, String status) {
	
		this.articleName   = articleName;
		this.author        = author;
		this.category      = category;
		this.description   = description;
		this.dateOfPublish = dateOfPublish;
		this.status        = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
