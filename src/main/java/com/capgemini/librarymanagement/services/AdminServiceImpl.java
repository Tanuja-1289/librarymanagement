package com.capgemini.librarymanagement.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.AdminDao;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utility.Validator;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	
	@Autowired
	private Validator validate;


	@Override
	public Users addLibrarian(Users librarian) {
		if(validate.password(librarian.getPassword())  ) {
			return dao.addLibrarian(librarian);
		}else {
			return null;
		}
		
	}


	@Override
	public Users updateLibrarian(Users librarian) {
		if(validate.password(librarian.getPassword()) ) {
			return dao.updateLibrarian(librarian);
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteLibrarian(String librarianId) {
		return dao.deleteLibrarian(librarianId);
	}

	@Override
	public List<Users> searchLibrarian() {
		return dao.searchLibrarian();
	}

}
