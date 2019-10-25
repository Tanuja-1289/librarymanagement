package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.dao.AdminDao;
import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utils.ValidatorImplementation;

public class AdminServicesImpl implements AdminServices{
		
	@Autowired
	AdminDao dao;
	
	@Autowired
	ValidatorImplementation regex;

	@Override
	public boolean addLibrarian(String username, String password) {

		if(regex.validatePassword(password)) {
		return dao.addLibrarian(username, password);
	}else {
		return false;
	}
}

	@Override
	public boolean removeLibrarian(String username) {
		return dao.removeLibrarian(username);
	}

	@Override
	public List<Users> showAllLibrarian() {

		return dao.showAllLibrarian();
	}

	@Override
	public boolean addStudent(String username, String password) {
		if(regex.validateId(username) && regex.validatePassword(password)) {
			return dao.addStudent(username,password);
		}else {
			return false;
		}
	}

	@Override
	public boolean removeStudent(String username) {
		return dao.removeStudent(username);
	}

	@Override
	public List<Users> showAllStudent() {
		return dao.showAllStudent();
	}

	@Override
	public List<BookInventory> showAllBook() {
		return dao.showAllBook();
	}

	@Override
	public List<BookRegistration> showAllRegistration() {
		return  dao.showAllRegistration();
	}

	@Override
	public List<BookTransaction> showAllTransaction() {
		return dao.showAllTransaction();
	}

	
}
