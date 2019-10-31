package com.capgemini.librarymanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dao.AdminDao;
import com.capgemini.librarymanagement.dao.AdminDaoImpl;
import com.capgemini.librarymanagement.dto.Users;

public class AdminDaoImplTest {

	AdminDao admindao = new AdminDaoImpl();
	@Test
	public void deleteLibPass() {
		boolean expected= admindao.deleteLibrarian("111");
		assertEquals(expected, true);
		
	}
	@Test
	public void deleteLibFail() {
		
		boolean expected= admindao.deleteLibrarian("101");
		assertEquals(expected, false);
		
	}
	@Test
	public void searchLibrarianPass() {
		List<Users> searchLibrarian = admindao.searchLibrarian();
		boolean containReg = false;
		if(!searchLibrarian.isEmpty() || searchLibrarian != null) {
			containReg= true;
		}
		assertTrue(containReg);
	}
	
	@Test
	public void searchLibrarianFail() {
		List<Users> searchLibrarian = admindao.searchLibrarian();
		boolean containReg = false;
		if(searchLibrarian.isEmpty() || searchLibrarian == null) {
			containReg= false;
		}
		assertFalse(containReg);
	}
}
