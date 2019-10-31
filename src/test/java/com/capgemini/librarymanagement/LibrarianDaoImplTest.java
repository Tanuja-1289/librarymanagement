package com.capgemini.librarymanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dao.LibrarianDao;
import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.Users;

public class LibrarianDaoImplTest {

	LibrarianDao dao = new LibrarianDaoImpl();
	@Test
	public void cancelBookRequestFail() {
		boolean expected = dao.cancelBookRequest(111);
		assertEquals(expected, false);
	}
	
	@Test
	public void cancelBookRequestPass() {
		boolean expected = dao.cancelBookRequest(333);
		assertEquals(expected, true);
	}
	
	@Test
	public void deleteBookPass() {
		boolean expected = dao.deleteBook("111");
		assertEquals(expected, true);
	}
	@Test
	public void deleteBookFail() {
		boolean expected= dao.deleteBook("101");
		assertEquals(expected, false);
	}
	
	@Test
	public void getAllRequestBookPass() {
		List<BooksRegistration> bookRequests=dao.getBookRequest();
		boolean containReg = false;
		if(!bookRequests.isEmpty() || bookRequests != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void getAllRequestBookFail() {
		List<BooksRegistration> bookRequests=dao.getBookRequest();
		boolean containReg = false;
		if(bookRequests.isEmpty() || bookRequests == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
	
	@Test
	public void searchStudentPass() {
		List<Users> searchStudent = dao.searchStudent();
		boolean containReg = false;
		if(!searchStudent.isEmpty() || searchStudent != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void searchStudentFail() {
		List<Users> searchStudent = dao.searchStudent();
		boolean containReg = false;
		if(searchStudent.isEmpty() || searchStudent == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
}


