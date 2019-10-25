package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.dao.StudentDao;
import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.utils.ValidatorImplementation;

public class StudentServicesImpl implements StudentServices {

	@Autowired
	StudentDao dao;

	@Autowired
	ValidatorImplementation regex;

	@Override
	public BookInventory searchBook(int bookId) {
		return dao.searchBook(bookId);
	}

	@Override
	public List<BookInventory> showAllBook() {
		return dao.showAllBook();
	}

	@Override
	public boolean requestBook(int bookId, String studentName) {
		return dao.requestBook(bookId, studentName);
	}

	@Override
	public List<BookTransaction> showAllBorrowed(String studentName) {
		return dao.showAllBorrowed(studentName);
	}

}
