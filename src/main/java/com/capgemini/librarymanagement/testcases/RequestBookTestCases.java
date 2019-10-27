package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.StudentDaoImpl;

public class RequestBookTestCases {
	
	@Test
	public void requestbookPass() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		boolean expected = studentDaoImpl.requestBook(100,"bindu");
		assertEquals(expected, true);
	}
	@Test
	public void requestbookFail() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		boolean expected = studentDaoImpl.requestBook(101,"sindhu");
		assertEquals(expected, false);
	}//not working
}
