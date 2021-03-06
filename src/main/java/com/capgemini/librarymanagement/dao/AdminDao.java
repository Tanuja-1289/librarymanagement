package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.Users;

public interface AdminDao {

	//Admin Operations
	public Users addLibrarian(Users librarian);
	public Users updateLibrarian(Users librarian);
	public boolean deleteLibrarian(String librarianId);
	public List<Users> searchLibrarian();

}
