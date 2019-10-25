package com.capgemini.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BookInventory {
	@Id
	@Column
	int bookId;
	@Column
	String title;
	@Column
	String author;
	@Column
	String category;
	@Column
	int copiesAvailable;
	
	//setters and getters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	
}//end class
