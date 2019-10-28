package com.capgemini.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.AdminDao;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utils.ValidatorImpl;

@Service
public class AdminServicesImpl implements AdminServices{
		
	@Autowired
	AdminDao dao;
	
	@Autowired
	ValidatorImpl regex;

	@Override
	public boolean addLibrarian(String username, String password) {
		return dao.addLibrarian(username, password);
	
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
		return dao.addStudent(username,password);
	}

	@Override
	public boolean removeStudent(String username) {
		return dao.removeStudent(username);
	}

	@Override
	public List<Users> showAllStudent() {
		return dao.showAllStudent();
	}

	

	
}
