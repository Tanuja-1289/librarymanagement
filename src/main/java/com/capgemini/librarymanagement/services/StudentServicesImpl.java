package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.StudentDao;
import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.utils.ValidatorImpl;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	StudentDao dao;

	@Autowired
	ValidatorImpl regex;

	
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
	
	public List<BookRegistration> showAllRequested(String studentName){
		return dao.showAllRequested(studentName);
	}

	@Override
	public BookInventory searchBook(String title, String author) {
		return dao.searchBook(title, author);
	}

	

}
