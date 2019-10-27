package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;

public class ReturnBookTestCases {
	@Test
	public void returnBookPass() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.returnBook(999);
		assertEquals(expected, true);
	}
	@Test
	public void returnBookFail() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.returnBook(1000);
		assertEquals(expected, false);
	}

}
