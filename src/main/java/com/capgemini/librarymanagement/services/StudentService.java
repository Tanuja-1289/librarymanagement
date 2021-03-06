package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

public interface StudentService {

	// Student Operations
		public List<BooksInventory> searchForBook(String bookName);
		public BooksRegistration makeBookRequest(String bookId);
		public List<BooksRegistration> getAllRequestedBook();
		public boolean cancelRequestedBook(int registrationId);
		public List<BooksTransaction> getResponse();
		public boolean returnBook(int transactionId);

}
