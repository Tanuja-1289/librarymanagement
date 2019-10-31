package com.capgemini.librarymanagement.services;

import java.util.List;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;

public interface LibrarianService {

	// Librarian Operations
		public BooksInventory addNewBook(BooksInventory booksInvent);
		public BooksInventory updateBook(BooksInventory booksInvent);
		public boolean deleteBook(String bookId);
		public List<BooksRegistration> getBookRequest();
		public boolean cancelBookRequest(int registrationId);
		public BooksTransaction responseBookRequest(int registrationId);
		public Users addNewStudent(Users student);
		public List<Users> searchStudent();
		public boolean deleteStudent(String studentId);
		public Users updateStudent(Users student);


}
