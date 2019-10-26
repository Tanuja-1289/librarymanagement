package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;

public interface LibrarianServices {
	public boolean addBook(BookInventory book);
	public boolean updateBook(BookInventory book);
	public boolean removeBook(int bookId);
	
	public List<BookRegistration> showAllRegistration();
	public boolean cancelRegistration(int registrationId);
	public boolean issueBook(int registrationId);
	
	public List<BookTransaction> showAllIssued();
	public boolean returnBook(int transactionId);
	
	public List<BookInventory> showAllBook();
}
