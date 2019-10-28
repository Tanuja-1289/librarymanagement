package com.capgemini.librarymanagement;

import static org.junit.Assert.assertEquals;

import java.awt.print.Book;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;
import com.capgemini.librarymanagement.dto.BookInventory;

public class AddBookTestCases {
	BookInventory book = new BookInventory(); 
	
	@Test
	public void addbookPass() {
		book.setBookId(101);
		book.setTitle("C++");
		book.setAuthor("Nanjesh");
		book.setCategory("CS");
		book.setCopiesAvailable(11);
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected =librarianDaoImpl.addBook(book);
		assertEquals(expected, true);	
	}
	@Test
	public void addbookFail() {
		book.setBookId(100);
		book.setTitle("C++");
		book.setAuthor("Nanjesh");
		book.setCategory("CS");
		book.setCopiesAvailable(11);
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected =librarianDaoImpl.addBook(book);
		assertEquals(expected, false);	
	}

}
