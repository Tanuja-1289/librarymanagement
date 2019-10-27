package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.AdminDaoImpl;

public class AddLibrarianTestCases {

	@Test
	public void addlibrarianFail() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.addLibrarian("abc","xyz");
		assertEquals(expected, false);
	}

	@Test
	public void addlibrarianPass() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.addLibrarian("sindhu", "sindhu");
		assertEquals(expected, true);

	}


}
