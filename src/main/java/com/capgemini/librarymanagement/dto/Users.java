package com.capgemini.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Users {
	@Id
	@Column
	String username;
	@Column
	String password;
	@Column
	char type;
	
	//setters and getters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
}//end class
