package com.vg.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author
{
	@Id
	@Column(name="Auth_id")
	private int authorID;
	@Column(name="Auth_name")
	private String authorName;
	public Author() {}
	public Author(int authorID, String authorName) {
	
		this.authorID = authorID;
		this.authorName = authorName;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
