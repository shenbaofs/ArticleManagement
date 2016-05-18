package com.objectfrontier.training.article.model;

import java.util.Date;

public class Article {
	
	private long id;
	private String  articleName;
	private String  category;
	private String  description;
	private Date    dateOfPublish;
	private String  status;
	private long    authorId;
	private String  authorName;
	private String  authorCarrerProfile;
	private byte[]  authorImage;
	
	public Article() {}
	
	public Article(String articleName, String category, String description, Date dateOfPublish, 
				   String status, long authorId, String authorName, String authorCarrerProfile, byte[] authorImage) {
	
		this.articleName   = articleName;
		this.category      = category;
		this.description   = description;
		this.dateOfPublish = dateOfPublish;
		this.status        = status;
		this.authorId      = authorId;
		this.authorName    = authorName;
		this.authorCarrerProfile = authorCarrerProfile;
		this.authorImage   = authorImage;
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

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorCarrerProfile() {
		return authorCarrerProfile;
	}

	public void setAuthorCarrerProfile(String authorCarrerProfile) {
		this.authorCarrerProfile = authorCarrerProfile;
	}

	public byte[] getAuthorImage() {
		return authorImage;
	}

	public void setAuthorImage(byte[] authorImage) {
		this.authorImage = authorImage;
	}
}
