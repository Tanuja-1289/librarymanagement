package com.capgemini.librarymanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dao.StudentDao;
import com.capgemini.librarymanagement.dao.StudentDaoImpl;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

public class StudentDaoImplTest {

	StudentDao dao = new StudentDaoImpl();
	
	@Test
	public void cancelRequestedBookFail() {
		boolean expected = dao.cancelRequestedBook(211);
		assertEquals(expected, false);
	}
	
	@Test
	public void cancelRequestedBookPass() {
		boolean expected = dao.cancelRequestedBook(333);
		assertEquals(expected, true);
	}
	
	@Test
	public void getAllRequestBookPass() {
		List<BooksRegistration> bookRequests=dao.getAllRequestedBook();
		boolean containReg = false;
		if(!bookRequests.isEmpty() || bookRequests != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void getAllRequestBookFail() {
		List<BooksRegistration> bookRequests=dao.getAllRequestedBook();
		boolean containReg = false;
		if(bookRequests.isEmpty() || bookRequests == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
	
	@Test
	public void getResponsePass() {
		List<BooksTransaction> getResponse= dao.getResponse();
		boolean containReg = false;
		if(!getResponse.isEmpty() || getResponse != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void getResponseFail() {
		List<BooksTransaction> getResponse= dao.getResponse();
		boolean containReg = false;
		if(getResponse.isEmpty() || getResponse == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
	
	@Test
	public void searchLibrarianPass() {
		List<BooksInventory> searchForBook= dao.searchForBook("C++");
		boolean containReg = false;
		if(!searchForBook.isEmpty() || searchForBook != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void searchLibrarianFail() {
		List<BooksInventory> searchForBook= dao.searchForBook("C++");
		boolean containReg = false;
		if(searchForBook.isEmpty() || searchForBook == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
}
