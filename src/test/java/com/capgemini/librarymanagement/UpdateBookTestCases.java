package com.capgemini.librarymanagement;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;
import com.capgemini.librarymanagement.dto.BookInventory;

public class UpdateBookTestCases {
	BookInventory book = new BookInventory();
	@Test
	public void updateBookPass() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.updateBook(book);
		assertEquals(expected, true);
	}
	@Test
	public void updateBookFail() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.updateBook(book);
		assertEquals(expected, false);
	}

}
