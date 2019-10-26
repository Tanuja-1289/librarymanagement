package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.LibrarianDao;
import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.utils.ValidatorImplementation;

@Service
public class LibrarianServicesImpl implements LibrarianServices{

	@Autowired
	LibrarianDao dao;

	@Autowired
	ValidatorImplementation regex;

	@Override
	public boolean addBook(BookInventory book) {

		return dao.addBook(book);
	}

	@Override
	public boolean updateBook(BookInventory book) {

		return dao.updateBook(book);
	}

	@Override
	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	@Override
	public List<BookRegistration> showAllRegistration() {
		return dao.showAllRegistration();
	}

	@Override
	public boolean cancelRegistration(int registrationId) {
		return dao.cancelRegistration(registrationId);
	}

	@Override
	public boolean issueBook(int registrationId) {
		return dao.issueBook(registrationId);
	}

	@Override
	public List<BookTransaction> showAllIssued() {
		return dao.showAllIssued();
	}

	@Override
	public boolean returnBook(int transactionId) {
		return dao.returnBook(transactionId);
	}

	@Override
	public List<BookInventory> showAllBook() {
		return dao.showAllBook();
	}

	

}
