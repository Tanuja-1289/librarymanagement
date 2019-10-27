package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;

public class CancelRegistrationTetCases {
	
	@Test
	public void cancelregPass() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.cancelRegistration(111);
		assertEquals(expected, true);
	}
	
	@Test
	public void cancelregFail() {
		LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
		boolean expected = librarianDaoImpl.cancelRegistration(333);
		assertEquals(expected, false);
	}
	
}
