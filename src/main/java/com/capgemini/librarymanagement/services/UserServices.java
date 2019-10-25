package com.capgemini.librarymanagement.services;

import com.capgemini.librarymanagement.dto.Users;

public interface UserServices {
	public Users login(String username,String password);
}
