package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.dto.Users;

public interface AdminDao {

	public boolean addLibrarian(String username,String password);
	public boolean removeLibrarian(String username);
	public List<Users> showAllLibrarian();
	
	public boolean addStudent(String username,String password);
	public boolean removeStudent(String username);
	public List<Users> showAllStudent();
	
	public List<BookInventory> showAllBook();
	public List<BookRegistration> showAllRegistration();
	public List<BookTransaction> showAllTransaction();
}
