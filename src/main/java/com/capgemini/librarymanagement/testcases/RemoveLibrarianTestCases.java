package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.AdminDaoImpl;

public class RemoveLibrarianTestCases {
	@Test
	public void removelibPass() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.removeLibrarian("sindhu");
		assertEquals(expected, true);
	}
	
	@Test
	public void removelibFail() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.removeLibrarian("brunda");
		assertEquals(expected, false);
	}

}
