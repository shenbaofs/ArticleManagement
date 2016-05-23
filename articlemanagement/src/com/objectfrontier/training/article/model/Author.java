package com.objectfrontier.training.article.model;

public class Author {

	private long   authorId;
	private String  authorName;
	private String  authorCarrerProfile;
	private byte[]  authorImage;
	
	public Author() {}
	
	public Author(long authorId) {
		
		this.authorId = authorId;
	}
	
	public Author( String authorName, String authorCarrerProfile, byte[] authorImage) {
	
		this.authorName    = authorName;
		this.authorCarrerProfile = authorCarrerProfile;
		this.authorImage   = authorImage;
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
