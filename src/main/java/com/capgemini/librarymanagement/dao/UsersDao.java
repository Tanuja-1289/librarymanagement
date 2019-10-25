package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.Users;

public interface UsersDao {
	
	public Users login(String username,String password);

}
