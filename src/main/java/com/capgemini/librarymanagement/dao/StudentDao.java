package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookTransaction;

public interface StudentDao {
	
	public BookInventory searchBook(int bookId);
	public List<BookInventory> showAllBook();
	
	public boolean requestBook(int bookId, String studentName);
	public List<BookTransaction> showAllBorrowed(String studentName);
}
