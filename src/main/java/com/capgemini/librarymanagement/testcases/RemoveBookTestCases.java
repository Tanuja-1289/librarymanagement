package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;

public class RemoveBookTestCases {
	@Test
	public void removebookPass() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected= librarianDaoImpl.removeBook(100);
		assertEquals(expected, true);
	}
	@Test
	public void removebookFail() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected= librarianDaoImpl.removeBook(500);
		assertEquals(expected, false);
	}

}
