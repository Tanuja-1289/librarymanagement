package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminServices {
	public boolean addLibrarian(String username,String password);
	public boolean removeLibrarian(String username);
	public List<Users> showAllLibrarian();
	
	public boolean addStudent(String username,String password);
	public boolean removeStudent(String username);
	public List<Users> showAllStudent();
	
	
}
