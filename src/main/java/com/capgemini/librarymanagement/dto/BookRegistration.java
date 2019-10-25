package com.capgemini.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class BookRegistration {
	@Id
	@Column
	private int registrationId;
	@Column
	private int bookId;
	@Column
	private String studentName;
	@Column
	private Date registrationDate;
	
	//setters and getters
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}//end class
