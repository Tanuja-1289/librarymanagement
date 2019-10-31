package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.LibrarianDao;
import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utility.Validator;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private LibrarianDao dao;
	
	@Autowired
	private Validator validate;


	@Override
	public BooksInventory addNewBook(BooksInventory booksInvent) {
		return dao.addNewBook(booksInvent);
	}

	@Override
	public BooksInventory updateBook(BooksInventory booksInvent) {
		return dao.updateBook(booksInvent);
	}

	@Override
	public boolean deleteBook(String bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public List<BooksRegistration> getBookRequest() {
		return dao.getBookRequest();
	}

	@Override
	public boolean cancelBookRequest(int registrationId) {
		return dao.cancelBookRequest(registrationId);
	}

	@Override
	public Users addNewStudent(Users student) {
		if(validate.password(student.getPassword()) ) {
			return dao.addNewStudent(student);
		}else {
			return null;
		}
	}

	@Override
	public List<Users> searchStudent() {
		return dao.searchStudent();
	}

	@Override
	public boolean deleteStudent(String studentId) {
		return dao.deleteStudent(studentId);
	}

	@Override
	public BooksTransaction responseBookRequest(int registrationId) {
		return dao.responseBookRequest(registrationId);
	}

	@Override
	public Users updateStudent(Users student) {
		if(validate.password(student.getPassword()) ) {
			return dao.updateStudent(student);
		}else {
			return null;
		}
	}

}
