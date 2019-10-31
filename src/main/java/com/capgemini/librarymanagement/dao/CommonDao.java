package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.Users;

public interface CommonDao {

	// Login Functionality
	public Users login(Users user);
}
