package com.capgemini.librarymanagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;

public class IssueBookTestCases {
	
	@Test
	public void issuebookPass() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.issueBook(111);
		assertEquals(expected, true);
	}

	@Test
	public void issuebookFail() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.issueBook(444);
		assertEquals(expected, false);
	}

}
