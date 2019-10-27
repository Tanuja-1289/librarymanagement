package com.capgemini.librarymanagement.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.librarymanagement.dao.AdminDaoImpl;

public class AddStudentTestCases {

	@Test
	public void addstudentFail() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.addStudent("bindu", "qwerty");
		assertEquals(expected, false);
	}
	@Test
	public void addstudentPass() {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		boolean expected = adminDaoImpl.addStudent("brunda", "brunda");
		assertEquals(expected, true);
	}


}
